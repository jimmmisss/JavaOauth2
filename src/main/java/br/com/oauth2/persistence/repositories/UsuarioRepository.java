package br.com.oauth2.persistence.repositories;

import br.com.oauth2.persistence.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);

}
