package br.com.oauth2.persistence.services;

import br.com.oauth2.persistence.models.Produto;
import br.com.oauth2.persistence.repositories.ProdutoRepository;
import br.com.oauth2.persistence.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> BuscaTodosProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos == null)
            throw new ObjectNotFoundException("Produtos não encontrados: " + Produto.class.getName());
        return produtos;
    }

    public Produto BuscaUmProduto(Long id) {
        Produto produto = produtoRepository.findOne(id);
        if(produto == null)
            throw new ObjectNotFoundException("Produto não encontrado: " + id + ", tipo: " + Produto.class.getName());
        return produto;
    }

}
