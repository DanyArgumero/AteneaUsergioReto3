package com.example.reto3.Service;

import com.example.reto3.Repository.ClientRepository;
import com.example.reto3.Model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService {
    @Autowired
    private ClientRepository ClientRepository;

    public List<ClientModel> getAll() {
        return ClientRepository.findAllClients();
    }

    public Optional<ClientModel> getById(int id) {
        return ClientRepository.findById(id);
    }

    public ClientModel save(ClientModel Client) {
        if (Client.getIdClient() == null) {
            return ClientRepository.save(Client);
        } else {
            Optional<ClientModel> FindClient = getById(Client.getIdClient());
            if (FindClient.isEmpty())
                return ClientRepository.save(Client);
            else
                return Client;
        }
    }

    public ClientModel update(ClientModel Client) {
        if(Client.getIdClient() != null){
            Optional<ClientModel> FindClient = getById(Client.getIdClient());
            if (FindClient.isPresent()) {
                if (Client.getEmail() != null) {
                    FindClient.get().setEmail(Client.getEmail());
                }
                if (Client.getName() != null) {
                    FindClient.get().setName(Client.getName());
                }
                if (Client.getPassword() != null) {
                    FindClient.get().setPassword(Client.getPassword());
                }
                if (Client.getAge() != null) {
                    FindClient.get().setAge(Client.getAge());
                }
                return ClientRepository.save(FindClient.get());
            }else {
                return Client;
            }
        }else{
            return Client;
        }
    }

    public boolean deleteClientById(int id){
        Boolean respuesta = getById(id).map(Client -> {
            ClientRepository.Delete(Client);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
