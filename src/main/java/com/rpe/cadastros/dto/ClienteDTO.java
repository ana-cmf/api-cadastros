package com.rpe.cadastros.dto;

import java.time.LocalDate;

public record ClienteDTO(
    String CPF,
    String nome,
    EnderecoDTO endereco,
    String telefone,
    LocalDate dataUltimoServico
) {

}
