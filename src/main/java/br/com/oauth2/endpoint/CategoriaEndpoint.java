package br.com.oauth2.endpoint;

import br.com.oauth2.persistence.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class CategoriaEndpoint {

    private CategoriaService categoriaService;

    @Autowired
    public CategoriaEndpoint(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @ResponseBody
    @GetMapping(value = "protected/categorias")
    public ResponseEntity<?> listaTodos() {
        return new ResponseEntity<>(categoriaService.buscaTodasCategorias(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "protected/categoria/{id}")
    public ResponseEntity<?> listaUmaCategoria(@PathVariable Integer id) {
        return new ResponseEntity<>(categoriaService.buscaUmaCategoria(id), HttpStatus.OK);
    }


}
