package cm.beni.main.julia.dao.controller.repository.julia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//SELECT identify, level, password, firstName, lastName, birthday, birthLocation, cni, email 
	@Query("FROM User WHERE userName=:userName")
	User findUserByUserName(@Param("userName") String userName);
}
