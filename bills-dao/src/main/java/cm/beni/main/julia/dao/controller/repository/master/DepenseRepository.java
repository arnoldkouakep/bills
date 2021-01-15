package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.depenses.Depense;

public interface DepenseRepository extends JpaRepository<Depense, Long> {

	@Query("FROM Depense WHERE code LIKE :code")
	Collection<Depense> getDepensesByCode(@Param("code") String code);

}
