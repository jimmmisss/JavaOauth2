package br.com.oauth2.persistence.services;

import br.com.oauth2.persistence.models.Categoria;
import br.com.oauth2.persistence.repositories.CategoriaRepository;
import br.com.oauth2.persistence.services.exceptions.DataIntegrityException;
import br.com.oauth2.persistence.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        List<Categoria> categorias = repository.findAll();
        if(categorias == null)
            throw new ObjectNotFoundException("Produtos não encontrados: " + Categoria.class.getName());
        return categorias;
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Categoria findOne(Integer id) {
        Categoria categoria = repository.findOne(id);
        if(categoria == null)
            throw new ObjectNotFoundException("Produto não encontrado: " + id + ", tipo: " + Categoria.class.getName());
        return categoria;
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Categoria obj) {
        findOne(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findOne(id);
        try {
            repository.delete(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível deletar uma categoria que tem produtos");
        }
    }

}
