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
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService MessageService;

    @GetMapping("/all")
    public List<MessageModel> getAll(){
        return MessageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MessageModel> getMessage(@PathVariable int id){
        return MessageService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel save(@RequestBody MessageModel Message){
        return MessageService.save(Message);
    }
}
