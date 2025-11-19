package com.soa_td.td1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.soa_td.td1.model.Server;
import com.soa_td.td1.repository.serverRepository;


@Service
public class serverService {

    private final serverRepository serverRepository;

    public serverService(serverRepository serverRepository){
        this.serverRepository=serverRepository;
    }

    //Lister tous les serveurs
    public List<Server> getServer() {
        return serverRepository.findAll();
    }
    //Trouver le serveur par ID
    public Server getServer(@PathVariable Long id) {
        return serverRepository.findById(id).orElse(new Server());
    }
    //creer un serveur
    public Server createServer(@RequestBody Server server){
        return serverRepository.save(server);
    }
    //Renommee un serveur
    public Server updateServerName(@PathVariable Long id, @RequestBody Server serverDetails){
        Server existingServer = serverRepository.findById(id).orElse(new Server());
        existingServer.setName(serverDetails.getName());
        return serverRepository.save(existingServer);
    }
    //Recuperer le status du serveur
    public Boolean getServerStatus(@PathVariable Long id) {
        Server serverStatus = serverRepository.findById(id).orElse(new Server());
        return serverStatus.getStatus();
    }
    //Demarrer un serveur
    public Server updateServerStatus(@PathVariable Long id, @RequestBody Server serverDetails){
        Server existingServer = serverRepository.findById(id).orElse(new Server());
        existingServer.setStatus(serverDetails.getStatus());
        return serverRepository.save(existingServer);
    }
    //Supprimer un serveur
    public void deleteServer(@PathVariable Long id){
        serverRepository.deleteById(id);
    }
}
