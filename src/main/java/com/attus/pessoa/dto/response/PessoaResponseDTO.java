// Representa os dados retornados ao solicitar informações de uma pessoa. Criado por Lucas de Freitas.

package com.attus.pessoa.dto.response;

import java.time.LocalDate;
import com.attus.pessoa.entity.Pessoa;

import lombok.Getter;

@Getter
public class PessoaResponseDTO {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String lougradouro;

    private Integer numero;

    private String cidade;

    private String estado;

    private Integer cep;

    public PessoaResponseDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.lougradouro = pessoa.getLogradouro();
        this.numero = pessoa.getNumero();
        this.cidade = pessoa.getCidade();
        this.estado = pessoa.getEstado();
        this.cep = pessoa.getCep();
    }

}
