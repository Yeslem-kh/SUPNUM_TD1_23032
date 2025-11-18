package com.soa_td.td1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soa_td.td1.model.Server;

public interface serverRepository extends JpaRepository<Server, Long>{
}
