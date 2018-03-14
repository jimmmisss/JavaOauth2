package br.com.oauth2.endpoint;

import br.com.oauth2.persistence.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class ProdutoEndpoint {

    private ProdutoService produtoService;

    @Autowired
    public ProdutoEndpoint(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @ResponseBody
    @GetMapping(value = "protected/produtos")
    public ResponseEntity<?> listaTodos() {
        return new ResponseEntity<>(produtoService.BuscaTodosProdutos(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "protected/produto/{id}")
    public ResponseEntity<?> listaUmProduto(@PathVariable Long id) {
        return new ResponseEntity<>(produtoService.BuscaUmProduto(id), HttpStatus.OK);
    }

}