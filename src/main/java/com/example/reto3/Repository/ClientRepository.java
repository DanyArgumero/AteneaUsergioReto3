package com.example.reto3.Repository;

import ch.qos.logback.core.net.server.Client;
import com.example.reto3.Model.ClientModel;
import com.example.reto3.Repository.CRUDRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository ClientCrudRepository;

    public List<ClientModel> findAllClients() {
        return (List<ClientModel>) ClientCrudRepository.findAll();
    }

    public Optional<ClientModel> findById(int id){
        return ClientCrudRepository.findById(id);
    }

    public ClientModel save(ClientModel Client){
        return ClientCrudRepository.save(Client);
    }

    public void Delete(ClientModel client){
        ClientCrudRepository.delete(client);
    }
}
