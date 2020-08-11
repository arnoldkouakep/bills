package cm.beni.main.julia.dao.controller.repository.julia;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.access.UserRoles;


public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {

	@Query("FROM UserRoles WHERE user=:user")
	Collection<UserRoles> getUserRolesOfUser(@Param("user") String user);

}
