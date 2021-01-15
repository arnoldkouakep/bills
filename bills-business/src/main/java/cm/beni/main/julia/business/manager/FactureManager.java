package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.FactureRepository;
import cm.beni.main.julia.model.schema.factures.Facture;

@Component
public class FactureManager {

//	@Autowired
	private Facture facture;
	
	@Autowired
	private RubriquesFactureManager rubriqueFactureManager;

	@Autowired
	private FactureRepository factureRepository;

	public Facture create(Facture facture) {
		facture.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.facture = facture;
		factureRepository.save(this.facture);

		rubriqueFactureManager.createOrUpdateOrDeleteAll(this.facture.getIdentify(), this.facture.getRubriquesFactures());
		return this.facture;
	}

	public Facture update(Facture facture) {
		this.facture = facture;
		factureRepository.save(this.facture);
		return this.facture;
	}

	public Collection<Facture> getAllFactures() {
		return factureRepository.findAll();
	}

	public Collection<Facture> getFacturesByNumeroFacture(String numeroFacture) {
		return factureRepository.getFacturesByNumeroFacture(numeroFacture);
	}

}
