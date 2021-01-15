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

import cm.beni.main.julia.business.manager.PersonnalManager;
import cm.beni.main.julia.model.schema.dossiers.Personnal;


@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("dossier-api")
public class BillsPersonnalService {

	@Autowired
	private PersonnalManager personnalManager;

	@RequestMapping("/personnals")
	public ResponseEntity<Collection<Personnal>> getAllPersonnals() {
		Collection<Personnal> personnals = personnalManager.getAllPersonnals();

		if (personnals == null || personnals.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(personnals, HttpStatus.OK);
	}

	@RequestMapping("/personnals/by-code")
	public ResponseEntity<Collection<Personnal>> getPersonnalsByNumeroPersonnal(@RequestParam String code) {
		Collection<Personnal> personnals = personnalManager.getPersonnalsByCode(code);

		if (personnals == null || personnals.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(personnals, HttpStatus.OK);
	}

	@RequestMapping(value = "/personnal/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Personnal> create(@RequestBody Personnal personnal) {
		personnal = personnalManager.create(personnal);
		return new ResponseEntity<>(personnal, HttpStatus.OK);
	}

	@RequestMapping(value = "/personnal/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Personnal> update(@RequestBody Personnal personnal) {
		personnal = personnalManager.update(personnal);
		return new ResponseEntity<>(personnal, HttpStatus.OK);
	}
}
