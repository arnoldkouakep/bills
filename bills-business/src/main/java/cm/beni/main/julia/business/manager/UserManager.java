package cm.beni.main.julia.business.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.julia.UserRepository;
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

	public User create(User user) {
		user.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.user = user;
		userRepository.save(this.user);
		return this.user;
	}

	public User update(User user) {
		this.user = user;
		userRepository.save(this.user);
		return this.user;
	}

	public User getUserByUserName(String userName) {
		user = userRepository.findUserByUserName(userName);
		return user;
	}

}
