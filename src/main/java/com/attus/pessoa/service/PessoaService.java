// Fornece operações para manipular informações de pessoas. Criado por Lucas de Freitas.
package com.attus.pessoa.service;

import com.attus.pessoa.dto.request.PessoaRequestDTO;
import com.attus.pessoa.dto.response.PessoaResponseDTO;

import java.util.List;

public interface PessoaService {

    PessoaResponseDTO findById(Long id);

    List<PessoaResponseDTO> findAll();

    PessoaResponseDTO register(PessoaRequestDTO pessoaDTO);

    PessoaResponseDTO update(Long id, PessoaRequestDTO pessoaDTO);

    String delete(Long id);

}
