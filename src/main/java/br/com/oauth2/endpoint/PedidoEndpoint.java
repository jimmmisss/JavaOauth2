package br.com.oauth2.endpoint;

import br.com.oauth2.persistence.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class PedidoEndpoint {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "protected/pedidos")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(pedidoService.listaTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "protected/pedido/{id}")
    public ResponseEntity<?> findOne(@PathVariable Integer id) {
        return new ResponseEntity<>(pedidoService.listaUmPedido(id), HttpStatus.OK);
    }

}