package com.example.reto3.Repository;
import com.example.reto3.Model.MessageModel;
import com.example.reto3.Repository.CRUDRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository MessageCrudRepository;

    public List<MessageModel> findAllMessages() {
        return (List<MessageModel>) MessageCrudRepository.findAll();
    }

    public Optional<MessageModel> findById(int id){
        return MessageCrudRepository.findById(id);
    }

    public MessageModel save(MessageModel Message){
        return MessageCrudRepository.save(Message);
    }

    public void Delete(MessageModel message){
        MessageCrudRepository.delete(message);
    }
}
