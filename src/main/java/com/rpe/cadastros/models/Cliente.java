package com.rpe.cadastros.models;

import java.time.LocalDate;

import com.rpe.cadastros.dto.ClienteDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cliente {

    @Id
    private String CPF;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    @Column(nullable = true)
    private String telefone;

    @Column(name = "data_ultimo_servico", nullable = false)
    private LocalDate dataUltimoServico;
   
}
