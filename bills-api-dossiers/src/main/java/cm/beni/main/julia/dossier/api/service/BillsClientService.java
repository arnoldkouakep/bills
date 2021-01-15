package cm.beni.main.julia.dossier.api.service;

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

import cm.beni.main.julia.business.manager.ClientManager;
import cm.beni.main.julia.model.schema.dossiers.Client;

@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("dossier-api")
public class BillsClientService {

	@Autowired
	private ClientManager clientManager;

	@RequestMapping("/clients")
	public ResponseEntity<Collection<Client>> getAllClients() {
		Collection<Client> clients = clientManager.getAllClients();

		if (clients == null || clients.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@RequestMapping("/clients/by-code")
	public ResponseEntity<Collection<Client>> getAllClients(@RequestParam String code) {
		Collection<Client> clients = clientManager.getClientByPersonnalCode(code);

		if (clients == null || clients.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@RequestMapping(value = "/client/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Client> create(@RequestBody Client client) {
		client = clientManager.create(client);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@RequestMapping(value = "/client/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Client> update(@RequestBody Client client) {
		client = clientManager.update(client);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
}
