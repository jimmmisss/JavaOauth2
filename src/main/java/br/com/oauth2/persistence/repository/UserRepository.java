package br.com.oauth2.persistence.repository;

import br.com.oauth2.persistence.models.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<Usuario, Long>{

    Usuario findByUsuario(String usuario);

}
