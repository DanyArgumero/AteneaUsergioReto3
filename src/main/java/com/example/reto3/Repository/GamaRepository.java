package com.example.reto3.Repository;
import com.example.reto3.Model.GamaModel;
import com.example.reto3.Repository.CRUDRepository.GamaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository {
    @Autowired
    private GamaCrudRepository GamaCrudRepository;

    public List<GamaModel> findAllGamas() {
        return (List<GamaModel>) GamaCrudRepository.findAll();
    }

    public Optional<GamaModel> findById(int id){
        return GamaCrudRepository.findById(id);
    }

    public GamaModel save(GamaModel Gama){
        return GamaCrudRepository.save(Gama);
    }

    public void Delete(GamaModel gama){
        GamaCrudRepository.delete(gama);
    }
}
