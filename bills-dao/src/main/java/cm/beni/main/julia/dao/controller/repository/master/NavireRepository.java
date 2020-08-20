package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.navires.Navire;

public interface NavireRepository extends JpaRepository<Navire, Long> {

	@Query("FROM Navire WHERE code=:code")
	Navire getNavireByCode(@Param("code") String code);

	@Query("FROM Navire ORDER BY :orderBy")
	Collection<Navire> findAllOrderByLimit(@Param("orderBy") String orderBy);

	@Query("FROM Navire WHERE ORDER BY :orderBy LIMIT :limit")
	Collection<Navire> findAllOrderBy(@Param("orderBy") String orderBy, @Param("limit") int limit);

}
