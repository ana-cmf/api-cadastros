package com.rpe.cadastros.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.rpe.cadastros.models.Cliente;
import com.rpe.cadastros.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarCliente(String cpf){
        return this.clienteRepository.findById(cpf);
    }

    public Cliente editarCliente(Cliente cliente){
        Optional<Cliente> clienteEncontrado = buscarCliente(cliente.getCPF());
        Cliente clienteNovo = clienteEncontrado.get();
        return this.clienteRepository.save(clienteNovo);
        
    }

    public void deletar(String cpf){
        this.clienteRepository.deleteById(cpf);
    }

}
