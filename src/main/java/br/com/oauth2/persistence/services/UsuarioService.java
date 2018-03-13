package br.com.oauth2.persistence.services;

import br.com.oauth2.persistence.models.Usuario;
import br.com.oauth2.persistence.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    public Usuario BuscaUsuarioLogado(String usuario) {
        Usuario user = repo.findByUsuario(usuario);
        return user;
    }

    public Usuario BuscaUmUsuario(long id) {
        Usuario user = repo.findOne(id);
        return user;
    }

    public List<Usuario> BuscaTodosUsuarios() {
        List<Usuario> user = repo.findAll();
        return user;
    }

}