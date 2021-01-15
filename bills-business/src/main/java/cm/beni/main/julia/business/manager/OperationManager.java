package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.OperationRepository;
import cm.beni.main.julia.model.schema.factures.Operation;

@Component
public class OperationManager {

//	@Autowired
	private Operation operation;

	@Autowired
	private OperationRepository operationRepository;

	public Operation create(Operation operation) {
		operation.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.operation = operation;
		operationRepository.save(this.operation);
		return this.operation;
	}

	public Operation update(Operation operation) {
		this.operation = operation;
		operationRepository.save(this.operation);
		return this.operation;
	}

	public Collection<Operation> getAllOperations(){
		return operationRepository.findAll();
	}

	public Collection<Operation> getOperationsByCode(String code) {
		return operationRepository.getOperationsByCode(code);
	}

}
