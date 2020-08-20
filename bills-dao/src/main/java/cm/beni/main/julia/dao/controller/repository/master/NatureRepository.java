package cm.beni.main.julia.dao.controller.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.beni.main.julia.model.schema.factures.Facture;

public interface NatureRepository extends JpaRepository<Facture, Long> {

}
