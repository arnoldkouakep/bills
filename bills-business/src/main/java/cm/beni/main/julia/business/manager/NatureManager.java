package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.NatureRepository;
import cm.beni.main.julia.model.schema.factures.Nature;

@Component
public class NatureManager {

//	@Autowired
	private Nature nature;

	@Autowired
	private NatureRepository natureRepository;

	public Nature create(Nature nature) {
		nature.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.nature = nature;
		natureRepository.save(this.nature);
		return this.nature;
	}

	public Nature update(Nature nature) {
		this.nature = nature;
		natureRepository.save(this.nature);
		return this.nature;
	}

	public Collection<Nature> getAllNatures(){
		return natureRepository.findAll();
	}

	public Collection<Nature> getNaturesByCode(String code) {
		return natureRepository.getNaturesByCode(code);
	}

}
