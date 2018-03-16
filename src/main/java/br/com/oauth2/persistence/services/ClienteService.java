package br.com.oauth2.persistence.services;

import br.com.oauth2.persistence.models.Cliente;
import br.com.oauth2.persistence.repositories.ClienteRepository;
import br.com.oauth2.persistence.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listaTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        if(clientes == null)
            throw new ObjectNotFoundException("Clientes não encontrados: " + Cliente.class.getName());
        return clientes;
    }

    public Cliente listaUmCliente(Integer id) {
        Cliente cliente = clienteRepository.findOne(id);
        if(cliente == null)
            throw new ObjectNotFoundException("Cliente não encontrado: " + id + Cliente.class.getName());
        return cliente;
    }

}