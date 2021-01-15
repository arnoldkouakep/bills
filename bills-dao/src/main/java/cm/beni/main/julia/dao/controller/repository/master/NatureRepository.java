package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.factures.Nature;

public interface NatureRepository extends JpaRepository<Nature, Long> {

	@Query("FROM Nature WHERE code LIKE :code")
	Collection<Nature> getNaturesByCode(@Param("code") String code);

}
