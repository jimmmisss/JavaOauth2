package br.com.oauth2.endpoint.v1;

import br.com.oauth2.exception.error.ResourceNotFoundException;
import br.com.oauth2.persistence.models.Usuario;
import br.com.oauth2.persistence.repositories.UsuarioRepository;
import br.com.oauth2.persistence.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("v1")
public class UsuarioEndpoint {

    private final UsuarioRepository ur;
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioEndpoint(UsuarioRepository ur, UsuarioService usuarioService) {
        this.ur = ur;
        this.usuarioService = usuarioService;
    }

    @ResponseBody
    @GetMapping(path = "protected/usuario/logado")
    public Usuario currentUserName(Principal principal) {
        Usuario usuario = usuarioService.BuscaUsuarioLogado(principal.getName());
        usuario.setSenha("");
        return usuario;
    }

    @ResponseBody
    @GetMapping(path = "admin/usuarios")
    public ResponseEntity<?> usuarios() {
        return new ResponseEntity<>(usuarioService.BuscaTodosUsuarios(), HttpStatus.OK);
    }

    @GetMapping(path = "protected/usuario/{id}")
    public ResponseEntity<?> buscaUmUsuario(@PathVariable long id) {
        verificaSeExisteUsuario(id);
        Usuario user = usuarioService.BuscaUmUsuario(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private void verificaSeExisteUsuario(long id) {
        if(usuarioService.BuscaUmUsuario(id) == null)
            throw new ResourceNotFoundException("Usuário não encontrado: " + id);
    }

}