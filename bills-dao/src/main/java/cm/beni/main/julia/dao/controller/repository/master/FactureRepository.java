package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.factures.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

	@Query("FROM Facture WHERE (numeroFacture LIKE :numeroFacture OR identify =:numeroFacture)")
	Collection<Facture> getFacturesByNumeroFacture(@Param("numeroFacture") String numeroFacture);
}
