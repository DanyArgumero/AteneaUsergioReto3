package com.example.reto3.Repository;
import com.example.reto3.Model.Score;
import com.example.reto3.Repository.CRUDRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository ScoreCrudRepository;

    public List<Score> findAllScores() {
        return (List<Score>) ScoreCrudRepository.findAll();
    }

    public Optional<Score> findById(int id){
        return ScoreCrudRepository.findById(id);
    }

    public Score save(Score Score){
        return ScoreCrudRepository.save(Score);
    }

    public void Delete(Score score){
        ScoreCrudRepository.delete(score);
    }

}
