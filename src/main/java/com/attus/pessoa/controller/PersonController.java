// Gerencia as requisições relacionadas a pessoas na API. Criado por Lucas de Freitas.
package com.attus.pessoa.controller;

import com.attus.pessoa.dto.request.PessoaRequestDTO;
import com.attus.pessoa.dto.response.PessoaResponseDTO;
import com.attus.pessoa.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
@RequiredArgsConstructor
public class PersonController {

    private final PessoaService pessoaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> register(@RequestBody PessoaRequestDTO personRequestDTO,
            UriComponentsBuilder uriBuilder) {

        PessoaResponseDTO pessoaResponseDTO = pessoaService.register(personRequestDTO);

        URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoaResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoaResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> update(@RequestBody PessoaRequestDTO pessoaDTO,
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(pessoaService.update(id, pessoaDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(pessoaService.delete(id));
    }

}
