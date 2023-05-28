package com.example.reto3.Service;

import com.example.reto3.Model.Score;
import com.example.reto3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private com.example.reto3.Repository.ScoreRepository ScoreRepository;

    public List<Score> getAll() {
        return ScoreRepository.findAllScores();
    }

    public Optional<Score> getById(int id) {
        return ScoreRepository.findById(id);
    }

    public Score save(Score Score) {
        if (Score.getIdScore() == null) {
            return ScoreRepository.save(Score);
        } else {
            Optional<Score> FindScore = getById(Score.getIdScore());
            if (FindScore.isEmpty())
                return ScoreRepository.save(Score);
            else
                return Score;
        }
    }

    public Score update(Score Score) {
        if(Score.getIdScore() != null){
            Optional<Score> FindScore = getById(Score.getIdScore());
            if (FindScore.isPresent()) {
                if (Score.getStars() != null) {
                    FindScore.get().setStars(Score.getStars());
                }
                if (Score.getMessageText() != null) {
                    FindScore.get().setMessageText(Score.getMessageText());
                }
                return ScoreRepository.save(FindScore.get());
            }else {
                return Score;
            }
        }else{
            return Score;
        }
    }

    public boolean deleteScoreById(int id){
        Boolean respuesta = getById(id).map(Score -> {
            ScoreRepository.Delete(Score);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
