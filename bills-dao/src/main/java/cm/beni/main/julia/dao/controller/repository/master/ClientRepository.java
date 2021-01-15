package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.dossiers.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("FROM Client WHERE personnal.code LIKE :code")
	Collection<Client> getClientByPersonnalCode(@Param("code") String code);

}
