package com.soa_td.td1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity 
@Table(name = "server")
public class Server {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="server_id")
    private Long id;
    @Column
    private String name;
    @Column
    private String ipAddress; 
    @Column
    private Boolean status;

    public Server() {
    }

    public Server(Long id, String name, String ipAddress, Boolean status) {
        this.id = id;
        this.name = name;
        this.ipAddress = ipAddress;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "server [id=" + id + ", name=" + name + ", ipAddress=" + ipAddress + ", status=" + status + "]";
    }
    
}
