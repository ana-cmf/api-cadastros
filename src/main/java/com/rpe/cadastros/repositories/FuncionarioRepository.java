package com.rpe.cadastros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpe.cadastros.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String>{

}
