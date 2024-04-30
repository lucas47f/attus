// Representa os dados necessários para criar uma nova pessoa. Criado por Lucas de Freitas.

package com.attus.pessoa.dto.request;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class PessoaRequestDTO {

    private String nome;

    private LocalDate dataNascimento;

    private String logradouro;

    private Integer numero;

    private String cidade;

    private String estado;

    private Integer cep;

}
