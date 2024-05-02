package com.rpe.cadastros.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Funcionario{

    @Id
    private String CPF;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String telefone;

    @Column(nullable = false)
    private String funcao;

    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private LocalDate dataContratacao;

}
