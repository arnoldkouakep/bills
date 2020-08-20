package cm.beni.main.julia.dao.controller.repository.julia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.security.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("FROM Role WHERE identify=:id")
	Role getRoleById(@Param("id") String id);

}
