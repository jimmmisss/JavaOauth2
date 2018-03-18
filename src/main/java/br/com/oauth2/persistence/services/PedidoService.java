package br.com.oauth2.persistence.services;

import br.com.oauth2.persistence.models.Pedido;
import br.com.oauth2.persistence.repositories.PedidoRepository;
import br.com.oauth2.persistence.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listaTodos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        if (pedidos == null)
            throw new ObjectNotFoundException("Pedidos não encontrados: " + Pedido.class.getName());
        return pedidos;
    }

    public Pedido listaUmPedido(Integer id) {
        Pedido pedido = pedidoRepository.findOne(id);
        if (pedido == null)
                throw new ObjectNotFoundException("Pedido não encontrado: " + id + Pedido.class.getName());
        return pedido;
    }

}
