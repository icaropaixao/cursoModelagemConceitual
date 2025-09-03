package com.icaropaixao.cursomodelagem.services;


import com.icaropaixao.cursomodelagem.domain.Pedido;
import com.icaropaixao.cursomodelagem.repositories.PedidoRepository;
import com.icaropaixao.cursomodelagem.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }



}
