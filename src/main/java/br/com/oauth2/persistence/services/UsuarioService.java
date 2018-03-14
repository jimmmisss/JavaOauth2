package br.com.oauth2.persistence.services;

import br.com.oauth2.persistence.models.Usuario;
import br.com.oauth2.persistence.repositories.UsuarioRepository;
import br.com.oauth2.persistence.services.exceptions.ObjectNotFoundException;
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
        if(user == null)
            throw new ObjectNotFoundException("Usuário não encontrado: " + id + ", tipo: " + Usuario.class.getName());
        return user;
    }

    public List<Usuario> BuscaTodosUsuarios() {
        List<Usuario> user = repo.findAll();
        if(user == null)
            throw new ObjectNotFoundException("Usuários não encontrados: " + Usuario.class.getName());
        return user;
    }

}