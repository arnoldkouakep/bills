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

import cm.beni.main.julia.business.manager.RubriquesFactureManager;
import cm.beni.main.julia.model.schema.factures.RubriquesFacture;

@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("facture-api")
public class BillsRubriquesFactureService {

	@Autowired
	private RubriquesFactureManager rubriquesFactureManager;

	@RequestMapping("/rubriques/join/facture")
	public ResponseEntity<Collection<RubriquesFacture>> getAllRubriquesFacture() {
		Collection<RubriquesFacture> rubriquesFactures = rubriquesFactureManager.getAllRubriquesFactures();

		if (rubriquesFactures == null || rubriquesFactures.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rubriquesFactures, HttpStatus.OK);
	}

	@RequestMapping("/rubriques/join/facture/by-numeroFacture")
	public ResponseEntity<Collection<RubriquesFacture>> getAllFacturesByNumeroFacture(
			@RequestParam String numeroFacture) {
		Collection<RubriquesFacture> rubriquesFactures = rubriquesFactureManager
				.getRubriquesFacturesByNumeroFacture(numeroFacture);

		if (rubriquesFactures == null || rubriquesFactures.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rubriquesFactures, HttpStatus.OK);
	}

	@RequestMapping(value = "/rubriques/join/facture/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<RubriquesFacture> create(@RequestBody RubriquesFacture rubriquesFacture) {
		rubriquesFacture = rubriquesFactureManager.create(rubriquesFacture);
		return new ResponseEntity<>(rubriquesFacture, HttpStatus.OK);
	}

	@RequestMapping(value = "/rubriques/join/facture/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<RubriquesFacture> update(@RequestBody RubriquesFacture rubriquesFacture) {
		rubriquesFacture = rubriquesFactureManager.update(rubriquesFacture);
		return new ResponseEntity<>(rubriquesFacture, HttpStatus.OK);
	}

	@RequestMapping("/rubriques/join/facture/load/from/dossier")
	public ResponseEntity<Collection<RubriquesFacture>> loadFactureFromNumeroDossier(
			@RequestParam String numeroDossier) {
		Collection<RubriquesFacture> rubriquesFactures = rubriquesFactureManager
				.loadRubriquesFactureFromNumeroDossier(numeroDossier);

		if (rubriquesFactures == null || rubriquesFactures.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rubriquesFactures, HttpStatus.OK);
	}

}
