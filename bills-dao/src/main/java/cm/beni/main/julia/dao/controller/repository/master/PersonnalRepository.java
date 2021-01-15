package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.dossiers.Personnal;

public interface PersonnalRepository extends JpaRepository<Personnal, Long> {

	@Query("FROM Personnal WHERE code LIKE :code")
	Collection<Personnal> getPersonnalsByCode(@Param("code") String code);

}
