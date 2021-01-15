package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.factures.Rubrique;

public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {

	@Query("FROM Rubrique WHERE (libelle LIKE :libelle OR identify=:libelle)")
	Collection<Rubrique> getRubriquesByLibelle(@Param("libelle") String libelle);

	@Query("FROM Rubrique WHERE nature.identify LIKE :nature AND operation.identify LIKE :operation")
	Collection<Rubrique> getRubriquesByNatureAndOperation(@Param("nature") String nature, @Param("operation") String operation);
}
