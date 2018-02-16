package br.com.oauth2.security.service;

import br.com.oauth2.persistence.models.Usuario;
import br.com.oauth2.persistence.repository.UserRepository;
import br.com.oauth2.security.config.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Repository
@Transactional
public class UsuarioDetailService implements UserDetailsService {

    private final UserRepository ur;

    @Autowired
    public UsuarioDetailService(UserRepository ur) {
        this.ur = ur;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

        Usuario user = Optional.ofNullable(ur.findByUsuario(usuario))
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new MyUserDetails(user);

    }

}