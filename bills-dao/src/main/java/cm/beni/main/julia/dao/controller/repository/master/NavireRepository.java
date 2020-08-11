package cm.beni.main.julia.dao.controller.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.navires.Navire;

public interface NavireRepository extends JpaRepository<Navire, Long> {

	@Query("FROM Navire WHERE code=:code")
	Navire getNavireByCode(@Param("code") String code);

}
