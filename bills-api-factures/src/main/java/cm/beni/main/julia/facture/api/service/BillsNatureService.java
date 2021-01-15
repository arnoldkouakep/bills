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

import cm.beni.main.julia.business.manager.NatureManager;
import cm.beni.main.julia.model.schema.factures.Nature;


@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("facture-api")
public class BillsNatureService {

	@Autowired
	private NatureManager natureManager;

	@RequestMapping("/natures")
	public ResponseEntity<Collection<Nature>> getAllNatures() {
		Collection<Nature> natures = natureManager.getAllNatures();

		if (natures == null || natures.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(natures, HttpStatus.OK);
	}

	@RequestMapping("/natures/by-code")
	public ResponseEntity<Collection<Nature>> getAllClients(@RequestParam String code) {
		Collection<Nature> natures = natureManager.getNaturesByCode(code);

		if (natures == null || natures.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(natures, HttpStatus.OK);
	}

	@RequestMapping(value = "/nature/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Nature> create(@RequestBody Nature nature) {
		nature = natureManager.create(nature);
		return new ResponseEntity<>(nature, HttpStatus.OK);
	}

	@RequestMapping(value = "/nature/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Nature> update(@RequestBody Nature nature) {
		nature = natureManager.update(nature);
		return new ResponseEntity<>(nature, HttpStatus.OK);
	}
}
