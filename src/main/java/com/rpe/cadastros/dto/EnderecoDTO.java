package com.rpe.cadastros.dto;

public record EnderecoDTO(
    String numero,
    String rua,
    String bairro,
    String cidade,
    String estado,
    String pais
) {

}
