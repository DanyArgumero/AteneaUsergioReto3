package com.example.reto3.Repository;

import com.example.reto3.Model.CarModel;
import com.example.reto3.Repository.CRUDRepository.CarCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    @Autowired
    private CarCrudRepository carCrudRepository;

    public List<CarModel> findAllCars() {
        return  (List<CarModel>)  carCrudRepository.findAll();
    }

    public Optional<CarModel> findById(int id){
        return carCrudRepository.findById(id);
    }

    public CarModel save(CarModel car){
        return carCrudRepository.save(car);
    }

    public void Delete(CarModel car){
        carCrudRepository.delete(car);
    }
}
