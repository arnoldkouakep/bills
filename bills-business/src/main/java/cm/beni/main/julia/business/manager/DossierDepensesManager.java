package cm.beni.main.julia.business.manager;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.DossierDepensesRepository;
import cm.beni.main.julia.model.schema.depenses.DossierDepenses;

@Component
public class DossierDepensesManager {

//	@Autowired
	private DossierDepenses dossierDepenses;

	@Autowired
	private DossierDepensesRepository dossierDepensesRepository;

	public DossierDepenses create(DossierDepenses dossierDepenses) {
		dossierDepenses.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.dossierDepenses = dossierDepenses;
		dossierDepensesRepository.save(this.dossierDepenses);
		return this.dossierDepenses;
	}

	public Collection<DossierDepenses> createAll(Collection<DossierDepenses> dossierDepenseses) {
		for (DossierDepenses dossierDepenses : dossierDepenseses) {
			dossierDepenses.setIdentify(BusinessController.generateUIDPrimaryKey());
		}
		dossierDepensesRepository.saveAll(dossierDepenseses);
		return dossierDepenseses;
	}

	public DossierDepenses update(DossierDepenses dossierDepenses) {
		this.dossierDepenses = dossierDepenses;
		dossierDepensesRepository.save(this.dossierDepenses);
		return this.dossierDepenses;
	}

	public DossierDepenses updateAll(Collection<DossierDepenses> dossierDepenseses) {
		dossierDepensesRepository.saveAll(dossierDepenseses);
		return this.dossierDepenses;
	}

	public Collection<DossierDepenses> getAllDossierDepenses() {
		return dossierDepensesRepository.findAll();
	}

	public Collection<DossierDepenses> getDossierDepensesByDepense(String code) {
		return dossierDepensesRepository.getDossierDepensesByDepense(code);
	}

	public Collection<DossierDepenses> getDossierDepensesByDossier(String numeroDossier) {
		return dossierDepensesRepository.getDossierDepensesByDossier(numeroDossier, numeroDossier);
	}

	public Collection<DossierDepenses> getDossierDepensesByDossierAndDepense(String dossierId, String depenseId) {
		return dossierDepensesRepository.getDossierDepensesByDossierAndDepense(dossierId, depenseId);
	}

	public void createOrUpdateOrDeleteAll(String dossierId, Collection<DossierDepenses> dossierDepenseses) {
		Collection<DossierDepenses> oldDossierDepenseses = getDossierDepensesByDossier(dossierId);

		Collection<DossierDepenses> deleteDossierDepenseses = (oldDossierDepenseses == null) ? null
				: oldDossierDepenseses.stream().filter(dossierDepenses -> {
					if (dossierDepenseses.stream().filter(dp -> dossierDepenses.getIdentify().equals(dp.getIdentify()))
							.collect(Collectors.toList()).isEmpty())
						return true;
					return false;
				}).collect(Collectors.toList());

		dossierDepenseses.forEach(dossierDepenses -> {
			if (oldDossierDepenseses == null || oldDossierDepenseses.stream()
					.filter(dp -> dp.getIdentify().equals(dossierDepenses.getIdentify())).collect(Collectors.toList())
					.isEmpty())
				dossierDepenses.setIdentify(BusinessController.generateUIDPrimaryKey());
		});

		/*
		 * forEach(dossierDepenses -> { System.out.println(dp.getDate()); });
		 */

		dossierDepensesRepository.saveAll(dossierDepenseses);

		if (!deleteDossierDepenseses.isEmpty())
			dossierDepensesRepository.deleteAll(deleteDossierDepenseses);
	}

}
