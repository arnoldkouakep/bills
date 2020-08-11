package cm.beni.main.julia.dao.controller.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.beni.main.julia.model.schema.factures.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
