package com.example.reto3.Service;

import com.example.reto3.Model.CarModel;
import com.example.reto3.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<CarModel> getAll() {
        return carRepository.findAllCars();
    }

    public Optional<CarModel> getById(int id) {
        return carRepository.findById(id);
    }

    public CarModel save(CarModel car) {
        if (car.getIdCar() == null) {
            return carRepository.save(car);
        } else {
            Optional<CarModel> FindCar = getById(car.getIdCar());
            if (FindCar.isEmpty())
                return carRepository.save(car);
            else
                return car;
        }
    }

    public CarModel update(CarModel car) {
        if(car.getIdCar() != null){
            Optional<CarModel> FindCar = getById(car.getIdCar());
            if (FindCar.isPresent()) {
                if (car.getBrand() != null) {
                    FindCar.get().setBrand(car.getBrand());
                }
                if (car.getName() != null) {
                    FindCar.get().setName(car.getName());
                }
                if (car.getYear() != null) {
                    FindCar.get().setYear(car.getYear());
                }
                if (car.getDescription() != null) {
                    FindCar.get().setDescription(car.getDescription());
                }
                return carRepository.save(FindCar.get());
            }else {
                return car;
            }
        }else{
          return car;
        }
    }

    public boolean deleteCarById(int id){
        Boolean respuesta = getById(id).map(car -> {
            carRepository.Delete(car);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
