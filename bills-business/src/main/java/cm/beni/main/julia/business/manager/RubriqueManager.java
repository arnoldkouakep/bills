package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.RubriqueRepository;
import cm.beni.main.julia.model.schema.factures.Rubrique;

@Component
public class RubriqueManager {

//	@Autowired
	private Rubrique rubrique;

	@Autowired
	private RubriqueRepository rubriqueRepository;

	public Rubrique create(Rubrique rubrique) {
		rubrique.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.rubrique = rubrique;
		rubriqueRepository.save(this.rubrique);
		return this.rubrique;
	}

	public Rubrique update(Rubrique rubrique) {
		this.rubrique = rubrique;
		rubriqueRepository.save(this.rubrique);
		return this.rubrique;
	}

	public Collection<Rubrique> getAllRubriques() {
		return rubriqueRepository.findAll();
	}

	public Collection<Rubrique> getRubriquesByLibelle(String libelle) {
		return rubriqueRepository.getRubriquesByLibelle(libelle);
	}

	public Collection<Rubrique> getRubriquesByNatureAndOperation(String nature, String operation) {
		return rubriqueRepository.getRubriquesByNatureAndOperation(nature, operation);
	}

	public Collection<Rubrique> createOrUpdateAll(Collection<Rubrique> rubriques) {

		rubriques.forEach(rubrique -> {
			if (rubrique.getIdentify() == null)
				rubrique.setIdentify(BusinessController.generateUIDPrimaryKey());
		});

		rubriqueRepository.saveAll(rubriques);
		return rubriques;
	}

}
