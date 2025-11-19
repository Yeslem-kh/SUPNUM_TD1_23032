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
import com.soa_td.td1.service.serverService;

@RestController
public class serverController {

    private final serverService serverService;

    public serverController(serverService serverService){
        this.serverService = serverService;
    }
    //Lister tous les serveurs
    @GetMapping("/api/server")
    @ResponseStatus(HttpStatus.OK)
    public List<Server> getServer() {
        return serverService.getServer();
    }
    //trouver serveur par id
    @GetMapping("/api/server/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Server getServer(@PathVariable Long id) {
        return serverService.getServer(id);
    }
    //Create serveur
    @PostMapping("/api/server/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Server createServer(@RequestBody Server server){
        return serverService.createServer(server);
    }
    //Renommee un serveur
    @PutMapping("/api/server/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Server updateServerName(@PathVariable Long id, @RequestBody Server serverDetails){
        return serverService.updateServerName(id, serverDetails);
    }
    //Recuperer le status du serveur
    @GetMapping("/api/server/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean getServerStatus(@PathVariable Long id) {
        return serverService.getServerStatus(id);
    }
    //Demarrer un serveur
    @PutMapping("/api/server/update/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Server updateServerStatus(@PathVariable Long id, @RequestBody Server serverDetails){
        return serverService.updateServerStatus(id, serverDetails);
    }
    //Supprimer un serveur
    @DeleteMapping("/api/server/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteServer(@PathVariable Long id){
        serverService.deleteServer(id);
    }

    


}