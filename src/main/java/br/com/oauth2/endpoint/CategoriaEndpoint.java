package br.com.oauth2.endpoint;

import br.com.oauth2.persistence.DTO.CateroriaDTO;
import br.com.oauth2.persistence.models.Categoria;
import br.com.oauth2.persistence.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1")
public class CategoriaEndpoint {

    private CategoriaService categoriaService;

    @Autowired
    public CategoriaEndpoint(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "protected/categorias")
    public ResponseEntity<List<CateroriaDTO>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        List<CateroriaDTO> listDto = list.stream().map(obj -> new CateroriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "protected/categorias/page")
    public ResponseEntity<Page<CateroriaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Categoria> list = categoriaService.findPage(page, linesPerPage, orderBy, direction);
        Page<CateroriaDTO> listDto = list.map(obj -> new CateroriaDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "protected/categoria/{id}")
    public ResponseEntity<?> findOne(@PathVariable Integer id) {
        return new ResponseEntity<>(categoriaService.findOne(id), HttpStatus.OK);
    }

    @PostMapping(value = "admin/categoria")
    public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
        obj = categoriaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "admin/categoria/{id}")
    public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = categoriaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "admin/categoria/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
