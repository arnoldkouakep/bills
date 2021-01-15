package cm.beni.main.julia.business.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.RubriquesFactureRepository;
import cm.beni.main.julia.model.schema.dossiers.Dossier;
import cm.beni.main.julia.model.schema.factures.RubriquesFacture;

@Component
public class RubriquesFactureManager {

	private RubriquesFacture rubriquesFacture;

	@Autowired
	private DossierManager dossierManager;

	@Autowired
	private RubriquesFactureRepository rubriquesFactureRepository;

	public RubriquesFacture create(RubriquesFacture rubriquesFacture) {
		rubriquesFacture.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.rubriquesFacture = rubriquesFacture;
		rubriquesFactureRepository.save(this.rubriquesFacture);
		return this.rubriquesFacture;
	}

	public RubriquesFacture update(RubriquesFacture rubriquesFacture) {
		this.rubriquesFacture = rubriquesFacture;
		rubriquesFactureRepository.save(this.rubriquesFacture);
		return this.rubriquesFacture;
	}

	public Collection<RubriquesFacture> getAllRubriquesFactures(){
		return rubriquesFactureRepository.findAll();
	}

	public Collection<RubriquesFacture> getRubriquesFacturesByNumeroFacture(String numeroFacture) {
		return rubriquesFactureRepository.getRubriquesFacturesByNumeroFacture(numeroFacture);
	}

	public Collection<RubriquesFacture> loadRubriquesFactureFromNumeroDossier(String numeroDossier) {
		Collection<RubriquesFacture> rubriquesFactures = new ArrayList<RubriquesFacture>();
		Collection<Dossier> dossiers = dossierManager.getDossiersByNumeroDossier(numeroDossier);

		if (dossiers == null || dossiers.size() == 0) {
			new Exception("Aucun dossier - numero Dossier : " + numeroDossier);
		} else if (dossiers.size() > 1) {
			new Exception("Données duppliquées - numero Dossier : " + numeroDossier);
		}

		dossiers.forEach(dossier -> {
			if (dossier.getDossierDepenseses() != null && dossier.getDossierDepenseses().size() > 0)
				dossier.getDossierDepenseses().forEach(dossierDepense -> {
					rubriquesFactures.add(new RubriquesFacture(null, null,
							dossierDepense.getLibelle(), dossierDepense.getMontant(), !dossierDepense.isDebour(), null,
							dossierDepense, null, null, null, null));
				});
		});
		return rubriquesFactures;
	}
	

	public void createOrUpdateOrDeleteAll(String factureId, Collection<RubriquesFacture> rubriquesFactures) {
		Collection<RubriquesFacture> oldRubriquesFactures = getRubriquesFacturesByNumeroFacture(factureId);

		Collection<RubriquesFacture> deleteRubriquesFactures = (oldRubriquesFactures == null) ? null
				: oldRubriquesFactures.stream().filter(rubriquesFacture -> {
					if (rubriquesFactures.stream().filter(rf -> rubriquesFacture.getIdentify().equals(rf.getIdentify()))
							.collect(Collectors.toList()).isEmpty())
						return true;
					return false;
				}).collect(Collectors.toList());

		rubriquesFactures.forEach(rubriquesFacture -> {
			if (oldRubriquesFactures == null || oldRubriquesFactures.stream()
					.filter(rf -> rf.getIdentify().equals(rubriquesFacture.getIdentify())).collect(Collectors.toList())
					.isEmpty())
				rubriquesFacture.setIdentify(BusinessController.generateUIDPrimaryKey());
		});

		/*
		 * forEach(dossierDepenses -> { System.out.println(dp.getDate()); });
		 */

		rubriquesFactureRepository.saveAll(rubriquesFactures);

		if (!deleteRubriquesFactures.isEmpty())
			rubriquesFactureRepository.deleteAll(deleteRubriquesFactures);
	}


}
