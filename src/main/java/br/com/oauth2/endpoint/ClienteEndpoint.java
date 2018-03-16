package br.com.oauth2.endpoint;

import br.com.oauth2.persistence.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class ClienteEndpoint {

    private ClienteService clienteService;

    @Autowired
    public ClienteEndpoint(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ResponseBody
    @GetMapping(value = "protected/clientes")
    public ResponseEntity<?> listaTodos() {
        return new ResponseEntity<>(clienteService.listaTodos(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "protected/cliente/{id}")
    public ResponseEntity<?> listaUmCliente(@PathVariable Integer id) {
        return new ResponseEntity<>(clienteService.listaUmCliente(id), HttpStatus.OK);
    }

}