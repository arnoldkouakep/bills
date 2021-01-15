package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.navires.Navire;

public interface NavireRepository extends JpaRepository<Navire, Long> {

	@Query("FROM Navire WHERE code LIKE :code")
	Collection<Navire> getNaviresByCode(@Param("code") String code);

}
