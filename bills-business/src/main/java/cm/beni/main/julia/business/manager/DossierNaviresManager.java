package cm.beni.main.julia.business.manager;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.DossierNaviresRepository;
import cm.beni.main.julia.model.schema.dossiers.Dossier;
import cm.beni.main.julia.model.schema.navires.DossierNavires;

@Component
public class DossierNaviresManager {

//	@Autowired
	private DossierNavires dossierNavires;

	@Autowired
	private DossierNaviresRepository dossierNaviresRepository;

	public DossierNavires create(DossierNavires dossierNavires) {
		dossierNavires.setIdentify(BusinessController.generateUIDPrimaryKey());
		dossierNaviresRepository.save(this.dossierNavires);
		return this.dossierNavires;
	}

	public void createAll(Set<DossierNavires> dossierNavires) {
		for (DossierNavires dossierNavire : dossierNavires) {
			dossierNavire.setIdentify(BusinessController.generateUIDPrimaryKey());
		}
		dossierNaviresRepository.saveAll(dossierNavires);
	}

	public DossierNavires update(DossierNavires dossierNavires) {
		this.dossierNavires = dossierNavires;
		dossierNaviresRepository.save(this.dossierNavires);
		return this.dossierNavires;
	}

	public Collection<DossierNavires> getAllDossierNavires() {
		return dossierNaviresRepository.findAll();
	}

	public Collection<DossierNavires> getDossierNaviresByDossier(String id) {
		return dossierNaviresRepository.getDossierDepensesByDossier(id);
	}

	public Collection<DossierNavires> getDossierNaviresByNavire(String id) {
		return dossierNaviresRepository.getDossierNaviresByNavire(id);
	}

	public Collection<DossierNavires> getDossierNaviresByDossierAndNavire(String dossierId, String navireId) {
		return dossierNaviresRepository.getDossierDepensesByDossierAndNavire(dossierId, navireId);
	}

	public void createOrUpdateOrDeleteAll(Dossier dossier, Collection<DossierNavires> dossierNavireses) {
		Collection<DossierNavires> oldDossierNavireses = getDossierNaviresByDossier(dossier.getIdentify());

		Collection<DossierNavires> deleteDossierNavireses = (oldDossierNavireses == null) ? null
				: oldDossierNavireses.stream().filter(dossierNavires -> {
					if (dossierNavireses == null || dossierNavireses.stream()
							.filter(dn -> dossierNavires.getIdentify().equals(dn.getIdentify()))
							.collect(Collectors.toList()).isEmpty())
						return true;
					return false;
				}).collect(Collectors.toList());

		dossierNavireses.forEach(dossierNavires -> {
			if (oldDossierNavireses == null
					|| oldDossierNavireses.stream().filter(dn -> dn.getIdentify().equals(dossierNavires.getIdentify()))
							.collect(Collectors.toList()).isEmpty()) {
				dossierNavires.setIdentify(BusinessController.generateUIDPrimaryKey());
				dossierNavires.setDossier(dossier);
			}
		});

		dossierNaviresRepository.saveAll(dossierNavireses);

		if (!deleteDossierNavireses.isEmpty())
			dossierNaviresRepository.deleteAll(deleteDossierNavireses);
	}

}
