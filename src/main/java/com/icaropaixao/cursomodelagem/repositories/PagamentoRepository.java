package com.icaropaixao.cursomodelagem.repositories;


import com.icaropaixao.cursomodelagem.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                             //tipo    // tipo do identificador (id)
public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {



}
