package genspark.springboot_mysql.service;

import genspark.springboot_mysql.dao.ClientDao;
import genspark.springboot_mysql.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientDao clientDao;

    @Override
    public List<Client> findAllClients() {
        return clientDao.findAll();
    }

    @Override
    public Client findClientById(int clientId) {
        Client client;

        Optional<Client> opt = clientDao.findById(clientId);
        if (opt.isPresent()){
            client = opt.get();
        }else{
            throw new RuntimeException("Client "+ clientId+ " could not be found");
        }
        return client;
    }

    @Override
    public Client createClient(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDao.save(client);
    }

    @Override
    public String deleteClient(int clientId) {

        clientDao.deleteById(clientId);

        return "Client "+ clientId+ " successfully deleted";
    }

}
