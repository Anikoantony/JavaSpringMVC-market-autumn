package ru.geekbrains.marketautumn.repo;

import org.springframework.stereotype.Repository;
import ru.geekbrains.marketautumn.dto.Client;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ClientRepository {

    private List<Client> clients;

    @PostConstruct
    public void init() {
        clients = new ArrayList<>(Arrays.asList(
                new Client(1L, "Bob"),
                new Client(2L, "Jonh"),
                new Client(3L, "Dave")
        ));
    }

    public Client findById(Long id) {
        return clients.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
    }

    public void addClient(Long id, String name)
    {
        clients.add(new Client(id,name));
    }

    public void addClientPost(Client client)
    {
        clients.add(client);
    }

    public List<Client> getClients(){
        return clients;
    }

}
