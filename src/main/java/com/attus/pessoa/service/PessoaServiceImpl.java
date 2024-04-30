// Fornece operações para manipular informações de pessoas. Criado por Lucas de Freitas.

package com.attus.pessoa.service;

import com.attus.pessoa.dto.request.PessoaRequestDTO;
import com.attus.pessoa.dto.response.PessoaResponseDTO;
import com.attus.pessoa.entity.Pessoa;
import com.attus.pessoa.repository.PessoaRepository;
import com.attus.pessoa.util.PessoaMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper;

    @Override
    public PessoaResponseDTO findById(Long id) {
        return pessoaMapper.toPessoaDTO(returnPerson(id));
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        if (pessoas.isEmpty()) {
            throw new NoResultException("Não há pessoas cadastradas no banco de dados.");
        }
        return pessoaMapper.toPessoaDTO(pessoaRepository.findAll());
    }

    @Override
    public PessoaResponseDTO register(PessoaRequestDTO personDTO) {

        // Verificar se todos os campos obrigatórios estão preenchidos
        if (personDTO.getNome() == null || personDTO.getDataNascimento() == null || personDTO.getLogradouro() == null
                || personDTO.getNumero() == null || personDTO.getCidade() == null || personDTO.getEstado() == null
                || personDTO.getCep() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }

        Pessoa person = pessoaMapper.toPerson(personDTO);
        return pessoaMapper.toPessoaDTO(pessoaRepository.save(person));
    }

    @Override
    public PessoaResponseDTO update(Long id, PessoaRequestDTO personDTO) {

        // Verificar se todos os campos obrigatórios estão preenchidos
        if (personDTO.getNome() == null || personDTO.getDataNascimento() == null || personDTO.getLogradouro() == null
                || personDTO.getNumero() == null || personDTO.getCidade() == null || personDTO.getEstado() == null
                || personDTO.getCep() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }

        Pessoa person = returnPerson(id);
        pessoaMapper.updatePessoaData(person, personDTO);
        return pessoaMapper.toPessoaDTO(pessoaRepository.save(person));
    }

    @Override
    public String delete(Long id) {
        // Verificar se o ID existe antes de tentar deletar
        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pessoa com ID: " + id + " não encontrada.");
        }

        pessoaRepository.deleteById(id);
        return "Pessoa com ID: " + id + " deletada com sucesso.";
    }

    private Pessoa returnPerson(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada em nosso banco de dados."));
    }

}
