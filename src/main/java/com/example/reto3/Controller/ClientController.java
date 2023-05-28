package com.example.reto3.Controller;

import com.example.reto3.Service.ClientService;
import com.example.reto3.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ClientModel> getClient(@PathVariable int id){
        return clientService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel save(@RequestBody ClientModel Client){
        return clientService.save(Client);
    }
}
