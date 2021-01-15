package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.factures.RubriquesFacture;

public interface RubriquesFactureRepository extends JpaRepository<RubriquesFacture, Long> {

	@Query("FROM RubriquesFacture WHERE facture.numeroFacture LIKE :numeroFacture OR dossierDepense.depense.code LIKE :numeroFacture OR identify=:numeroFacture")
	Collection<RubriquesFacture> getRubriquesFacturesByNumeroFacture(@Param("numeroFacture") String numeroFacture);

}
