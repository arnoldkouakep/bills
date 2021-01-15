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

import cm.beni.main.julia.business.manager.FactureManager;
import cm.beni.main.julia.model.schema.factures.Facture;

@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("facture-api")
public class BillsFactureService {

	@Autowired
	private FactureManager factureManager;

	@RequestMapping("/factures")
	public ResponseEntity<Collection<Facture>> getAllFactures() {
		Collection<Facture> factures = factureManager.getAllFactures();

		if (factures == null || factures.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(factures, HttpStatus.OK);
	}

	@RequestMapping("/factures/by-numeroFacture")
	public ResponseEntity<Collection<Facture>> getAllFacturesByNumeroFacture(@RequestParam String numeroFacture) {
		Collection<Facture> factures = factureManager.getFacturesByNumeroFacture(numeroFacture);

		if (factures == null || factures.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(factures, HttpStatus.OK);
	}

	@RequestMapping(value = "/facture/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Facture> create(@RequestBody Facture facture) {
		facture = factureManager.create(facture);
		return new ResponseEntity<>(facture, HttpStatus.OK);
	}

	@RequestMapping(value = "/facture/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Facture> update(@RequestBody Facture facture) {
		facture = factureManager.update(facture);
		return new ResponseEntity<>(facture, HttpStatus.OK);
	}
}
