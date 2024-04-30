// Converte entre objetos DTO e entidades de Pessoa. Criado por Lucas de Freitas.

package com.attus.pessoa.util;

import com.attus.pessoa.dto.request.PessoaRequestDTO;
import com.attus.pessoa.dto.response.PessoaResponseDTO;
import com.attus.pessoa.entity.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    public Pessoa toPerson(PessoaRequestDTO pessoaDTO) {

        return Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .dataNascimento(pessoaDTO.getDataNascimento())
                .logradouro(pessoaDTO.getLogradouro())
                .numero(pessoaDTO.getNumero())
                .cidade(pessoaDTO.getCidade())
                .estado(pessoaDTO.getEstado())
                .cep(pessoaDTO.getCep())
                .build();

    }

    public PessoaResponseDTO toPessoaDTO(Pessoa pessoa) {
        return new PessoaResponseDTO(pessoa);
    }

    public List<PessoaResponseDTO> toPessoaDTO(List<Pessoa> peopleList) {
        return peopleList.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePessoaData(Pessoa pessoa, PessoaRequestDTO pessoaDTO) {

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoa.setLogradouro(pessoaDTO.getLogradouro());
        pessoa.setNumero(pessoaDTO.getNumero());
        pessoa.setCidade(pessoaDTO.getCidade());
        pessoa.setEstado(pessoaDTO.getEstado());
        pessoa.setCep(pessoaDTO.getCep());

    }

}
