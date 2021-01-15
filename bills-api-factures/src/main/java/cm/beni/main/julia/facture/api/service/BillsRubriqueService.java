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

import cm.beni.main.julia.business.manager.RubriqueManager;
import cm.beni.main.julia.model.schema.factures.Rubrique;

@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("facture-api")
public class BillsRubriqueService {

	@Autowired
	private RubriqueManager rubriqueManager;

	@RequestMapping("/rubriques")
	public ResponseEntity<Collection<Rubrique>> getAllRubriques() {
		Collection<Rubrique> rubriques = rubriqueManager.getAllRubriques();

		if (rubriques == null || rubriques.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rubriques, HttpStatus.OK);
	}

	@RequestMapping("/rubriques/by-libelle")
	public ResponseEntity<Collection<Rubrique>> getAllRubriqes(@RequestParam String libelle) {
		Collection<Rubrique> rubriques = rubriqueManager.getRubriquesByLibelle(libelle);

		if (rubriques == null || rubriques.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rubriques, HttpStatus.OK);
	}

	@RequestMapping("/rubriques/by-nature-operation")
	public ResponseEntity<Collection<Rubrique>> getAllRubriqesByNatureAndOperation(@RequestParam String nature, @RequestParam String operation) {
		Collection<Rubrique> rubriques = rubriqueManager.getRubriquesByNatureAndOperation(nature, operation);

		if (rubriques == null || rubriques.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rubriques, HttpStatus.OK);
	}

	@RequestMapping(value = "/rubrique/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Rubrique> create(@RequestBody Rubrique rubrique) {
		rubrique = rubriqueManager.create(rubrique);
		return new ResponseEntity<>(rubrique, HttpStatus.OK);
	}

	@RequestMapping(value = "/rubrique/create-update-list", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Collection<Rubrique>> createList(@RequestBody Collection<Rubrique> rubriques) {
		rubriques = rubriqueManager.createOrUpdateAll(rubriques);
		return new ResponseEntity<>(rubriques, HttpStatus.OK);
	}

	@RequestMapping(value = "/rubrique/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Rubrique> update(@RequestBody Rubrique rubrique) {
		rubrique = rubriqueManager.update(rubrique);
		return new ResponseEntity<>(rubrique, HttpStatus.OK);
	}
}
