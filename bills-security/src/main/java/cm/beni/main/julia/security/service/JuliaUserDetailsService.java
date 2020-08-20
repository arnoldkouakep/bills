package cm.beni.main.julia.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cm.beni.main.julia.business.manager.RoleManager;
import cm.beni.main.julia.business.manager.UserManager;
import cm.beni.main.julia.business.manager.UserRolesManager;
import cm.beni.main.julia.model.schema.access.UserRoles;
import cm.beni.main.julia.model.schema.security.Role;
import cm.beni.main.julia.model.schema.security.User;

@Service
public class JuliaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserManager userManager;

	@Autowired
	private UserRolesManager UserRolesManager;

	@Autowired
	private RoleManager roleManager;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userManager.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User name " + username + " not found.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), "{noop}" + 
		user.getPassword(),
				getGrantedAuthorities(user.getIdentify()));
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(String userId) {
		Collection<GrantedAuthority> grantAuthorities = new ArrayList<>();

		UserRolesManager.getUserRolesOfUser(userId).forEach((UserRoles userRole) -> {
			Role role = roleManager.getRoleById(userRole.getRole());
			grantAuthorities.add(new SimpleGrantedAuthority(role.getName()));

		});
		grantAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return grantAuthorities;
	}

}
