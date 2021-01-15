package cm.beni.main.julia.depense.api.service;

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

import cm.beni.main.julia.business.manager.DepenseManager;
import cm.beni.main.julia.model.schema.depenses.Depense;

@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("depense-api")
public class BillsDepenseService {

	@Autowired
	private DepenseManager depenseManager; 
	
	@RequestMapping("/depenses")
	public ResponseEntity<Collection<Depense>> getAllDepenses() {
		Collection<Depense> depenses = depenseManager.getAllDepenses();

		if (depenses == null || depenses.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(depenses, HttpStatus.OK);
	}

	@RequestMapping("/depenses/by-code")
	public ResponseEntity<Collection<Depense>> getDossiersByNumeroDossier(@RequestParam String code) {
		Collection<Depense> depenses = depenseManager.getDepensesByCode(code);

		if (depenses == null || depenses.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(depenses, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/depense/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Depense> create(@RequestBody Depense depense) {
		depense = depenseManager.create(depense);
		return new ResponseEntity<>(depense, HttpStatus.OK);
	}

	@RequestMapping(value = "/depense/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Depense> update(@RequestBody Depense depense) {
		depense = depenseManager.update(depense);
		return new ResponseEntity<>(depense, HttpStatus.OK);
	}
}
