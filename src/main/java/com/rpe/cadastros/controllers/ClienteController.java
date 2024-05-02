package com.rpe.cadastros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rpe.cadastros.dto.ClienteDTO;
import com.rpe.cadastros.models.Cliente;
import com.rpe.cadastros.services.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO clienteDTO, UriComponentsBuilder uriComponentsBuilder){
        URI uri = uriComponentsBuilder.path("/{cpf}").buildAndExpand(clienteDTO.CPF()).toUri();
        return ResponseEntity.created(uri).body(this.clienteService.criarCliente(clienteDTO));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable String cpf){
        Optional<Cliente> clienteEncontrado = this.clienteService.buscarCliente(cpf);
        if(clienteEncontrado.isPresent()){
            return ResponseEntity.ok(clienteEncontrado.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> editar(@RequestBody Cliente cliente, @PathVariable String cpf){
        Optional<Cliente> clienteEncontrado = this.clienteService.buscarCliente(cpf);

        if (clienteEncontrado.isPresent()) {
            ClienteDTO novoCliente = this.clienteService.editarCliente(clienteEncontrado.get().toDTO());
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<Void> deletar(@PathVariable String cpf){
        this.clienteService.deletar(cpf);
        return ResponseEntity.ok().build();
    }

}
