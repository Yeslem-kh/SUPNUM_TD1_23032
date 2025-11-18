package com.soa_td.td1.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.soa_td.td1.model.Server;
import com.soa_td.td1.repository.serverRepository;

@RestController
public class serverController {
    // private Server server;
    private final serverRepository serverRepository;

    public serverController(serverRepository serverRepository){
        // this.server = server;
        this.serverRepository = serverRepository;
    }
    //Lister tous les serveurs
    @GetMapping("/api/server")
    @ResponseStatus(HttpStatus.OK)
    public List<Server> getServer() {
        return serverRepository.findAll();
    }
    //trouver serveur par id
    @GetMapping("/api/server/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Server getServer(@PathVariable Long id) {
        return serverRepository.findById(id).orElse(new Server());
    }
    //Create serveur
    @PostMapping("/api/server/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Server createServer(@RequestBody Server Server){
        return serverRepository.save(Server);
    }
    //Renommee un serveur
    @PutMapping("/api/server/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Server updateServerName(@PathVariable Long id, @RequestBody Server serverDetails){
        Server existingServer = serverRepository.findById(id).orElse(new Server());
        existingServer.setName(serverDetails.getName());
        return serverRepository.save(existingServer);
    }
    //Recuperer le status du serveur
    @GetMapping("/api/server/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean getServerStatus(@PathVariable Long id) {
        Server serverStatus = serverRepository.findById(id).orElse(new Server());
        return serverStatus.getStatus();
    }
    //Demarrer un serveur
    @PutMapping("/api/server/update/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Server updateServerStatus(@PathVariable Long id, @RequestBody Server serverDetails){
        Server existingServer = serverRepository.findById(id).orElse(new Server());
        existingServer.setStatus(serverDetails.getStatus());
        return serverRepository.save(existingServer);
    }
    //Supprimer un serveur
    @DeleteMapping("/api/server/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteServer(@PathVariable Long id){
        serverRepository.deleteById(id);
    }

    


}