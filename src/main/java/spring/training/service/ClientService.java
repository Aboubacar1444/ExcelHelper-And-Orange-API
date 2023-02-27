package spring.training.service;

import spring.training.entity.Client;

import java.util.Collection;

public interface ClientService {
     public abstract void Save (Client client);
     public abstract void Update (Client client, Integer id);
     public abstract void Delete (Integer id);
     public abstract Collection <Client> getClients();
     public abstract Client findById(Integer id);

}
