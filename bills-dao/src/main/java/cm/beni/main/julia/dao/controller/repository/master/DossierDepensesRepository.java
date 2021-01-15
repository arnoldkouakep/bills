package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.depenses.DossierDepenses;

public interface DossierDepensesRepository extends JpaRepository<DossierDepenses, Long> {

	@Query("FROM DossierDepenses WHERE depense.code LIKE :code")
	Collection<DossierDepenses> getDossierDepensesByDepense(@Param("code") String code);

	@Query("FROM DossierDepenses WHERE (dossier.identify=:identify OR dossier.numeroDossier LIKE :numeroDossier)")
	Collection<DossierDepenses> getDossierDepensesByDossier(@Param("identify") String identify, @Param("numeroDossier") String numeroDossier);

	@Query("FROM DossierDepenses WHERE dossier.numeroDossier LIKE :numeroDossier AND depense.code LIKE :code")
	Collection<DossierDepenses> getDossierDepensesByDossierAndDepense(@Param("numeroDossier") String numeroDossier,
			@Param("code") String code);

}
