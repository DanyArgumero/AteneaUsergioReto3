package com.example.reto3.Service;

import com.example.reto3.Model.MessageModel;
import com.example.reto3.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository MessageRepository;

    public List<MessageModel> getAll() {
        return MessageRepository.findAllMessages();
    }

    public Optional<MessageModel> getById(int id) {
        return MessageRepository.findById(id);
    }

    public MessageModel save(MessageModel Message) {
        if (Message.getIdMessage() == null) {
            return MessageRepository.save(Message);
        } else {
            Optional<MessageModel> FindMessage = getById(Message.getIdMessage());
            if (FindMessage.isEmpty())
                return MessageRepository.save(Message);
            else
                return Message;
        }
    }

    public MessageModel update(MessageModel Message) {
        if(Message.getIdMessage() != null){
            Optional<MessageModel> FindMessage = getById(Message.getIdMessage());
            if (FindMessage.isPresent()) {
                if (Message.getMessageText() != null) {
                    FindMessage.get().setMessageText(Message.getMessageText());
                }
                return MessageRepository.save(FindMessage.get());
            }else {
                return Message;
            }
        }else{
            return Message;
        }
    }

    public boolean deleteMessageById(int id){
        Boolean respuesta = getById(id).map(Message -> {
            MessageRepository.Delete(Message);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
