package spring.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.training.entity.Client;
import org.springframework.stereotype.Service;
import spring.training.repository.ClientRepository;
import spring.training.service.ClientService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;


    private static Map<Integer, Client> ClientRepo = new HashMap<>();

    /**
     * @param client
     * @return
     */
    @Override
    public void Save(Client client) {
        ClientRepo.put(client.getId(), client);
        clientRepository.save(client) ;
    }

    /**
     * @param client
     * @param id
     */
    @Override
    public void Update(Client client, Integer id) {
        Client cli = findById(id);
        if (Objects.nonNull(client.getFullname()) && !"".equalsIgnoreCase(client.getFullname())){
            cli.setFullname(client.getFullname());
        }
        if (Objects.nonNull(client.getPhone()) && !"".equalsIgnoreCase(client.getPhone())){
            cli.setPhone(client.getPhone());
        }
        clientRepository.save(cli) ;
    }

    /**
     * @param id
     */
    @Override
    public void Delete(Integer id) {
        clientRepository.delete(ClientRepo.remove(id));
    }

    /**
     * @return
     */
    @Override
    public Collection <Client> getClients() {
        return clientRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Client findById(Integer id) {
        return clientRepository.findById(id).get();

    }
}
