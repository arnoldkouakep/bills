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
	
	public String create(String user, String role) {
		this.userRoles = new UserRoles(BusinessController.generateUIDPrimaryKey(), role, user);
		this.userRolesRepository.save(userRoles);
		return userRoles.getIdentify();
	}

	public Collection<UserRoles> getUserRolesOfUser(String user) {
		return userRolesRepository.getUserRolesOfUser(user);
	}

}
