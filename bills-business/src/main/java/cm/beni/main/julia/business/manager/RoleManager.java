package cm.beni.main.julia.business.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.julia.RoleRepository;
import cm.beni.main.julia.model.schema.security.Role;

@Component
public class RoleManager {

//	@Autowired
	private Role role;

	@Autowired
	private RoleRepository roleRepository;

	public RoleManager() {
		super();
	}

	public Role create(Role role) {
		role.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.role = role;
		this.roleRepository.save(role);
		return role;
	}

	public Role update(Role role) {
		this.role = role;
		this.roleRepository.save(role);
		return role;
	}

	public Role getRoleById(String id) {
		role = roleRepository.getRoleById(id);
		return role;
	}

}
