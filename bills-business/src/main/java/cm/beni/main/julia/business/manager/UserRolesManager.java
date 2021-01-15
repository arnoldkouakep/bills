package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.julia.UserRolesRepository;
import cm.beni.main.julia.model.schema.access.UserRoles;

@Component
public class UserRolesManager {

	private UserRoles userRoles;

	@Autowired
	private UserRolesRepository userRolesRepository;

	public UserRolesManager() {
		super();
	}
	
	public UserRoles create(UserRoles userRoles) {
		userRoles.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.userRoles = userRoles;
		this.userRolesRepository.save(this.userRoles);
		return this.userRoles;
	}

	public UserRoles update(UserRoles userRoles) {
		this.userRoles = userRoles;
		this.userRolesRepository.save(this.userRoles);
		return this.userRoles;
	}

	public Collection<UserRoles> getUserRolesOfUser(String user) {
		return userRolesRepository.getUserRolesOfUser(user);
	}

}
