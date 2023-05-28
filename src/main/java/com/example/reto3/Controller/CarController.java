package com.example.reto3.Controller;
import com.example.reto3.*;
import com.example.reto3.Model.CarModel;
import com.example.reto3.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<CarModel> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CarModel> getCar(@PathVariable int id){
        return carService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CarModel save(@RequestBody CarModel car){
        return carService.save(car);
    }
}
