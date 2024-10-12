package ma.oumaimaezafa.activite1.repositories;

import ma.oumaimaezafa.activite1.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,String> {
}
