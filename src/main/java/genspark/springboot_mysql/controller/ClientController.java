package genspark.springboot_mysql.controller;

import genspark.springboot_mysql.model.Client;
import genspark.springboot_mysql.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/")
    public String home(){
        return "<html><h1>Welcome to this API REST</h1></html>";
    }

    @GetMapping("/clients")
    public List<Client> findAllClient(){

        return clientService.findAllClients();
    }

    @GetMapping("/clients/{clientId}")
    public Client findClientById(@PathVariable int clientId){
        return clientService.findClientById(clientId);
    }

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/clients/{clientId}")
    public String deleteClient(@PathVariable int clientId){
        return clientService.deleteClient(clientId);
    }

}
