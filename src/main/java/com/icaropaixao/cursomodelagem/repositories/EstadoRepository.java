package com.icaropaixao.cursomodelagem.repositories;


import com.icaropaixao.cursomodelagem.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                             //tipo    // tipo do identificador (id)
public interface EstadoRepository extends JpaRepository<Estado,Integer> {



}
