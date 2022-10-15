package ru.geekbrains.marketautumn.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketautumn.dto.Client;
import ru.geekbrains.marketautumn.repo.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor // заинжектить репозиторий
public class ClientService {

    private final ClientRepository repository;

    public Client getClient(Long id){
        return repository.findById(id);
    }

    public List<Client> getAllClient(){
        return repository.getClients();
    }

    public void addClient (Long id, String name)
    {
        repository.addClient(id, name);
    }

    public void addClientPost (Client client)
    {
        repository.addClientPost(client);
    }
}
