package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.PersonnalRepository;
import cm.beni.main.julia.model.schema.dossiers.Personnal;

@Component
public class PersonnalManager {

//	@Autowired
	private Personnal personnal;

	@Autowired
	private PersonnalRepository personnalRepository;

	public Personnal create(Personnal personnal) {
		personnal.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.personnal = personnal;
		personnalRepository.save(this.personnal);
		return this.personnal;
	}

	public Personnal update(Personnal personnal) {
		this.personnal = personnal;
		personnalRepository.save(this.personnal);
		return this.personnal;
	}

	public Collection<Personnal> getAllPersonnals() {
		return personnalRepository.findAll();
	}
//	public Collection<Personnal> getAllPersonnalsOrderByWithLimit(String orderBy, String sens, int limit){
//		return personnalRepository.findAllOrderByLimit(orderBy, sens, limit, new PageRequest(0, 10, org.springframework.data.domain.Sort));
//	}

	public Collection<Personnal> getPersonnalsByCode(String code) {
		return personnalRepository.getPersonnalsByCode(code);
	}

}
