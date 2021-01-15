package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.dossiers.Dossier;

public interface DossierRepository extends JpaRepository<Dossier, Long> {
	
	@Query("FROM Dossier WHERE numeroDossier LIKE :numeroDossier")
	Collection<Dossier> getDossiersByNumeroDossier(@Param("numeroDossier") String numeroDossier);

}
