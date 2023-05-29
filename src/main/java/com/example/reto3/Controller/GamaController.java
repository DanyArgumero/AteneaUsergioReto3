package com.example.reto3.Controller;

import com.example.reto3.Service.*;
import com.example.reto3.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Gama")
public class GamaController {
    @Autowired
    private GamaService GamaService;

    @GetMapping("/all")
    public List<GamaModel> getAll(){
        return GamaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GamaModel> getGama(@PathVariable int id){
        return GamaService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public GamaModel save(@RequestBody GamaModel Gama){
        return GamaService.save(Gama);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public GamaModel update(@RequestBody GamaModel Gama){
        return GamaService.update(Gama);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return GamaService.deleteGamaById(id);
    }
}
