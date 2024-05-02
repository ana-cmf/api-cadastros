package com.rpe.cadastros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpe.cadastros.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
