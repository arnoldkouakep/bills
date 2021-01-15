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

import cm.beni.main.julia.business.manager.DossierManager;
import cm.beni.main.julia.model.schema.dossiers.Dossier;


@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("dossier-api")
public class BillsDossierService {

	@Autowired
	private DossierManager dossierManager;

	@RequestMapping("/dossiers")
	public ResponseEntity<Collection<Dossier>> getAllDossiers() {
		Collection<Dossier> dossiers = dossierManager.getAllDossiers();

		if (dossiers == null || dossiers.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dossiers, HttpStatus.OK);
	}

	@RequestMapping("/dossiers/by-numeroDossier")
	public ResponseEntity<Collection<Dossier>> getDossiersByNumeroDossier(@RequestParam String numeroDossier) {
		Collection<Dossier> dossiers = dossierManager.getDossiersByNumeroDossier(numeroDossier);

		if (dossiers == null || dossiers.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dossiers, HttpStatus.OK);
	}

	@RequestMapping(value = "/dossier/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Dossier> create(@RequestBody Dossier dossier) {
		dossier = dossierManager.create(dossier);
		return new ResponseEntity<>(dossier, HttpStatus.OK);
	}

	@RequestMapping(value = "/dossier/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Dossier> update(@RequestBody Dossier dossier) {
		dossier = dossierManager.update(dossier);
		return new ResponseEntity<>(dossier, HttpStatus.OK);
	}
	
}
