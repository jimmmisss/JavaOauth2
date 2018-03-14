package br.com.oauth2.persistence.repositories;

import br.com.oauth2.persistence.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
}
