package com.icaropaixao.cursomodelagem.repositories;

import com.icaropaixao.cursomodelagem.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                             //tipo    // tipo do identificador (id)
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {



}
