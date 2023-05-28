package com.example.reto3.Service;

import com.example.reto3.Model.GamaModel;
import com.example.reto3.Repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository GamaRepository;

    public List<GamaModel> getAll() {
        return GamaRepository.findAllGamas();
    }

    public Optional<GamaModel> getById(int id) {
        return GamaRepository.findById(id);
    }

    public GamaModel save(GamaModel Gama) {
        if (Gama.getIdGama() == null) {
            return GamaRepository.save(Gama);
        } else {
            Optional<GamaModel> FindGama = getById(Gama.getIdGama());
            if (FindGama.isEmpty())
                return GamaRepository.save(Gama);
            else
                return Gama;
        }
    }

    public GamaModel update(GamaModel Gama) {
        if(Gama.getIdGama() != null){
            Optional<GamaModel> FindGama = getById(Gama.getIdGama());
            if (FindGama.isPresent()) {
                if (Gama.getName() != null) {
                    FindGama.get().setName(Gama.getName());
                }
                if (Gama.getDescription() != null) {
                    FindGama.get().setDescription(Gama.getDescription());
                }
                return GamaRepository.save(FindGama.get());
            }else {
                return Gama;
            }
        }else{
            return Gama;
        }
    }

    public boolean deleteGamaById(int id){
        Boolean respuesta = getById(id).map(Gama -> {
            GamaRepository.Delete(Gama);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
