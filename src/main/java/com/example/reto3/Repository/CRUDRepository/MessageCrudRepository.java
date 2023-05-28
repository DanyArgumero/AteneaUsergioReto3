package com.example.reto3.Repository.CRUDRepository;

import com.example.reto3.Model.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel, Integer> {
}
