package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.NavireRepository;
import cm.beni.main.julia.model.schema.navires.Navire;

@Component
public class NavireManager {

//	@Autowired
	private Navire navire;

	@Autowired
	private NavireRepository navireRepository;

	public Navire create(Navire navire) {
		this.navire = new Navire(BusinessController.generateUIDPrimaryKey(), navire.getCode(), navire.getLibelle());
		navireRepository.save(this.navire);
		return this.navire;
	}

	public Collection<Navire> getAllNavires(){
		return navireRepository.findAll();
	}
	public Collection<Navire> getAllNaviresOrderBy(String orderBy){
		return navireRepository.findAllOrderBy(orderBy);
	}
	public Collection<Navire> getAllNaviresOrderByWithLimit(String orderBy, int limit){
		return navireRepository.findAllOrderByLimit(orderBy, limit);
	}
	
	public Navire getNavireByCode(String code) {
		navire = navireRepository.getNavireByCode(code);
		return navire;
	}

}
