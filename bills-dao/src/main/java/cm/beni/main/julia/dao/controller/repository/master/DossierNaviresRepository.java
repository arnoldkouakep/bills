package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.navires.DossierNavires;

public interface DossierNaviresRepository extends JpaRepository<DossierNavires, Long> {

	@Query("FROM DossierNavires WHERE dossier.identify=:dossierId")
	Collection<DossierNavires> getDossierDepensesByDossier(@Param("dossierId") String id);

	@Query("FROM DossierNavires WHERE navire.identify=:navireId")
	Collection<DossierNavires> getDossierNaviresByNavire(@Param("navireId") String id);

	@Query("FROM DossierNavires WHERE dossier.identify=:dossierId AND navire.identify=:navireId")
	Collection<DossierNavires> getDossierDepensesByDossierAndNavire(@Param("dossierId") String dossierId, @Param("navireId") String navireId);

}
