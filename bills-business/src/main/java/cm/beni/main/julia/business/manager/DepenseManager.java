package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.DepenseRepository;
import cm.beni.main.julia.model.schema.depenses.Depense;

@Component
public class DepenseManager {

//	@Autowired
	private Depense depense;

	@Autowired
	private DepenseRepository depenseRepository;

	public Depense create(Depense depense) {
		depense.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.depense = depense;
		depenseRepository.save(this.depense);

		return this.depense;
	}

	public Depense update(Depense depense) {
		this.depense = depense;
		depenseRepository.save(this.depense);

		return this.depense;
	}

	public Collection<Depense> getAllDepenses() {
		return depenseRepository.findAll();
	}

	public Collection<Depense> getDepensesByCode(String code) {
		return depenseRepository.getDepensesByCode(code);
	}

}
