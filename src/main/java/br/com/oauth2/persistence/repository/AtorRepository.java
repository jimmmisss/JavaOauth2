package br.com.oauth2.persistence.repository;

import br.com.oauth2.persistence.models.Ator;
import org.springframework.data.repository.CrudRepository;

public interface AtorRepository extends CrudRepository<Ator, Long>{

    Ator findById(long id);

}