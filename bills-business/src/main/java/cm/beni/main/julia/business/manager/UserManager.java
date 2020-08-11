package cm.beni.main.julia.business.manager;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.julia.UserRepository;
import cm.beni.main.julia.model.schema.access.Authorization;
import cm.beni.main.julia.model.schema.monitoring.Monitor;
import cm.beni.main.julia.model.schema.security.Level;
import cm.beni.main.julia.model.schema.security.User;

@Component
public class UserManager {

//	@Autowired
	private User user;

	@Autowired
	private UserRepository userRepository;

	public UserManager() {
		super();
	}

	public String create(Level level, String userName, String password, String firstName, String lastName,
			Date birthday, String birthLocation, String cni, String[] telephone, String email,
			Set<Authorization> authorizations, Set<Monitor> monitors) {

//		this.user = new User(BusinessController.generateUIDPrimaryKey(), 
// Level level, String userName, String password, String firstName, String lastName,
//						Date birthday, String birthLocation, String cni, Serializable telephone, String email,
//						Set<Authorization> authorizations, Set<Monitor> monitors)
//		this.userRepository.save(user);
		return null;
	}

	public String create(User user) {
		this.user = user;
		this.user.setIdentify(BusinessController.generateUIDPrimaryKey());
		userRepository.save(user);
		return this.user.getIdentify();
	}

	public User getUserByUserName(String userName) {
		user = userRepository.findUserByUserName(userName);
		return user;
	}

}
