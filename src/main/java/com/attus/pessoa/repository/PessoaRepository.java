// Gerencia as operações de banco de dados relacionadas a pessoas. Criado por Lucas de Freitas.

package com.attus.pessoa.repository;

import com.attus.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
