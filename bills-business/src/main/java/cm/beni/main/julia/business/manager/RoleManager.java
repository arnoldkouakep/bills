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

	public String create(String code, String name, String label) {
		this.role = new Role(BusinessController.generateUIDPrimaryKey(), code, name, label);
		this.roleRepository.save(role);
		return role.getIdentify();
	}

	public Role getRoleById(String id) {
		role = roleRepository.getRoleById(id);
		return role;
	}

}
