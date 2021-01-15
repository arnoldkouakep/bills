package cm.beni.main.julia.navire.api.service;

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

import cm.beni.main.julia.business.manager.DossierNaviresManager;
import cm.beni.main.julia.model.schema.navires.DossierNavires;


@CrossOrigin(origins = "http://localhost:27090")
@RestController
@RequestMapping("navire-api")
public class BillsDossierNaviresService {

	@Autowired
	private DossierNaviresManager dossierNaviresManager;

//	@RequestMapping("/hello/{name}")
//	public String helloName(@PathVariable("name") String name) {
//		return "Hello " + name;
//	}

//	@GetMapping("/navires/{orderBy}")
//	public ResponseEntity<Collection<Navire>> navires(@PathParam("orderBy") String orderBy) {
//		Collection<Navire> navires = navireManager.getAllNaviresOrderBy(orderBy);
//
//		if (navires == null || navires.size() == 0) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(navires, HttpStatus.OK);
//	}

//	@GetMapping("/navires/{orderBy}/{limit}")
//	public ResponseEntity<Collection<Navire>> navires(@PathParam("orderBy") String orderBy, @PathParam("limit") int limit) {
//		Collection<Navire> navires = navireManager.getAllNaviresOrderByWithLimit(orderBy, limit);
//
//		if (navires == null || navires.size() == 0) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(navires, HttpStatus.OK);
//	}

	@RequestMapping(value = "/navire/join/dossier/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<DossierNavires> create(@RequestBody DossierNavires dossierNavires) {
		dossierNavires = dossierNaviresManager.create(dossierNavires);
		return new ResponseEntity<>(dossierNavires, HttpStatus.OK);
	}

	@RequestMapping(value = "/navire/join/dossier/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<DossierNavires> update(@RequestBody DossierNavires dossierNavires) {
		dossierNavires = dossierNaviresManager.update(dossierNavires);
		return new ResponseEntity<>(dossierNavires, HttpStatus.OK);
	}
	

	@RequestMapping("/navire/join/dossier")
	public ResponseEntity<Collection<DossierNavires>> getAllNavireDossiers() {
		Collection<DossierNavires> dossierNavires = dossierNaviresManager.getAllDossierNavires();

		if (dossierNavires == null || dossierNavires.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dossierNavires, HttpStatus.OK);
	}

	@RequestMapping("/navire/join/dossier/by-dossier")
	public ResponseEntity<Collection<DossierNavires>> getAllNavireDossiersByDossier(@RequestParam String id) {
		Collection<DossierNavires> dossierNavires = dossierNaviresManager.getDossierNaviresByDossier(id);

		if (dossierNavires == null || dossierNavires.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dossierNavires, HttpStatus.OK);
	}

	@RequestMapping("/navire/join/dossier/by-navire")
	public ResponseEntity<Collection<DossierNavires>> getAllDepensesByNavire(@RequestParam String id) {
		Collection<DossierNavires> dossierNavires = dossierNaviresManager.getDossierNaviresByNavire(id);

		if (dossierNavires == null || dossierNavires.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dossierNavires, HttpStatus.OK);
	}

	@RequestMapping("/navire/join/dossier/by-dossier-and-navire")
	public ResponseEntity<Collection<DossierNavires>> getAllDepensesByDossierAndNavire(@RequestParam String dossierId, @RequestParam String navireId) {
		Collection<DossierNavires> dossierNavires = dossierNaviresManager.getDossierNaviresByDossierAndNavire(dossierId, navireId);

		if (dossierNavires == null || dossierNavires.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dossierNavires, HttpStatus.OK);
	}
}
