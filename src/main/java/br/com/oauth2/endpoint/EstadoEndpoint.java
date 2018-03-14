package br.com.oauth2.endpoint;

import br.com.oauth2.persistence.services.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class EstadoEndpoint {

    private final EstadoService estadoService;

    public EstadoEndpoint(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @ResponseBody
    @GetMapping(value = "/protected/estados")
    public ResponseEntity<?> buscaTodos() {
        return new ResponseEntity<>(estadoService.listaTodos(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "protected/estado/{id}")
    public ResponseEntity<?> listaUmEstado(@PathVariable Integer id) {
        return new ResponseEntity<>(estadoService.listaUmEstado(id), HttpStatus.OK);
    }

}
