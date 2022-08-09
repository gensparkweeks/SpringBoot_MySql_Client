package genspark.springboot_mysql.service;

import genspark.springboot_mysql.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAllClients();
    Client findClientById(int clientId);
    Client createClient(Client client);
    Client updateClient(Client client);
    String deleteClient(int clientId);

}
