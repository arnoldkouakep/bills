package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.DossierRepository;
import cm.beni.main.julia.model.schema.dossiers.Dossier;

@Component
public class DossierManager {

//	@Autowired
	private Dossier dossier;

	@Autowired
	private DossierRepository dossierRepository;

	@Autowired
	private DossierNaviresManager dossierNaviresManager;

	public Dossier create(Dossier dossier) {
		dossier.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.dossier = dossier;
		dossierRepository.save(this.dossier);

		dossierNaviresManager.createOrUpdateOrDeleteAll(this.dossier, this.dossier.getDossierNavireses());

		return this.dossier;
	}

	public Dossier update(Dossier dossier) {
		this.dossier = dossier;
		dossierRepository.save(this.dossier);

		dossierNaviresManager.createOrUpdateOrDeleteAll(this.dossier, this.dossier.getDossierNavireses());

		return this.dossier;
	}

	public Collection<Dossier> getAllDossiers() {
		return dossierRepository.findAll();
	}

	public Collection<Dossier> getDossiersByNumeroDossier(String numeroDossier) {
		// TODO Auto-generated method stub
		return dossierRepository.getDossiersByNumeroDossier(numeroDossier);
	}
}
