package com.rpe.cadastros.models;

import com.rpe.cadastros.dto.EnderecoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;
    
    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String pais;

    public EnderecoDTO toDTO(){
        return new EnderecoDTO(numero, rua, bairro, cidade, estado, pais);
    }

    public Endereco fromDTO(EnderecoDTO dto){
        Endereco endereco = new Endereco();
        endereco.setBairro(dto.bairro());
        endereco.setNumero(dto.numero());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setPais(dto.pais());
        endereco.setRua(dto.rua());
        return endereco;
    }
}
