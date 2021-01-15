package cm.beni.main.julia.facture.api.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cm.beni.main.julia.business.manager.OperationManager;
import cm.beni.main.julia.model.schema.factures.Operation;

@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("facture-api")
public class BillsOperationService {

	@Autowired
	private OperationManager operationManager;

	@RequestMapping("/operations")
	public ResponseEntity<Collection<Operation>> getAllOperations() {
		Collection<Operation> operations = operationManager.getAllOperations();

		if (operations == null || operations.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(operations, HttpStatus.OK);
	}

	@RequestMapping("/operations/by-code")
	public ResponseEntity<Collection<Operation>> getAllOperations(@RequestParam String code) {
		Collection<Operation> operations = operationManager.getOperationsByCode(code);

		if (operations == null || operations.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(operations, HttpStatus.OK);
	}

	@RequestMapping(value = "/operation/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Operation> create(@RequestBody Operation operation) {
		operation = operationManager.create(operation);
		return new ResponseEntity<>(operation, HttpStatus.OK);
	}

	@RequestMapping(value = "/operation/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Operation> update(@RequestBody Operation operation) {
		operation = operationManager.update(operation);
		return new ResponseEntity<>(operation, HttpStatus.OK);
	}
}
