package cm.beni.main.julia.dao.controller.repository.master;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.factures.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

	@Query("FROM Operation WHERE code LIKE :code")
	Collection<Operation> getOperationsByCode(@Param("code") String code);

}
