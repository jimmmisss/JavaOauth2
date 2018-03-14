package br.com.oauth2.persistence.services;

import br.com.oauth2.persistence.models.Categoria;
import br.com.oauth2.persistence.repositories.CategoriaRepository;
import br.com.oauth2.persistence.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscaTodasCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        if(categorias == null)
            throw new ObjectNotFoundException("Produtos não encontrados: " + Categoria.class.getName());
        return categorias;
    }

    public Categoria buscaUmaCategoria(Integer id) {
        Categoria categoria = categoriaRepository.findOne(id);
        if(categoria == null)
            throw new ObjectNotFoundException("Produto não encontrado: " + id + ", tipo: " + Categoria.class.getName());
        return categoria;
    }

}
