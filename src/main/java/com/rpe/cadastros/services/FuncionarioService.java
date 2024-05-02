package com.rpe.cadastros.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rpe.cadastros.models.Funcionario;
import com.rpe.cadastros.repositories.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public Funcionario criarFuncionario(Funcionario funcionario){
        return this.funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarFuncionario(String cpf){
        return this.funcionarioRepository.findById(cpf);
    }

    public Funcionario editarFuncionario(Funcionario funcionario){
        Optional<Funcionario> FuncionarioEncontrado = buscarFuncionario(funcionario.getCPF());
        Funcionario FuncionarioNovo = FuncionarioEncontrado.get();
        return this.funcionarioRepository.save(FuncionarioNovo);
        
    }

    public void deletar(String cpf){
        this.funcionarioRepository.deleteById(cpf);
    }
}
