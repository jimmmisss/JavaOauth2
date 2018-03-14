package br.com.oauth2.persistence.services;

import br.com.oauth2.persistence.models.Estado;
import br.com.oauth2.persistence.repositories.EstadoRepository;
import br.com.oauth2.persistence.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listaTodos() {
        List<Estado> estados = estadoRepository.findAll();
        if(estados == null)
            throw new ObjectNotFoundException("Produtos não encontrados: " + Estado.class.getName());
        return estados;
    }

    public Estado listaUmEstado(Integer id) {
        Estado estado = estadoRepository.findOne(id);
        if(estado == null)
            throw new ObjectNotFoundException("Produto não encontrado: " + id + ", tipo: " + Estado.class.getName());
        return estado;
    }

}
