package com.icaropaixao.cursomodelagem.repositories;

import com.icaropaixao.cursomodelagem.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                             //tipo    // tipo do identificador (id)
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {



}
