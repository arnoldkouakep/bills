package cm.beni.main.julia.navire.api.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cm.beni.main.julia.business.manager.NavireManager;
import cm.beni.main.julia.model.schema.navires.Navire;

@RestController
public class BillsNavireService {

	@Autowired
	private NavireManager navireManager;

	@RequestMapping("/")
	public String hello() {
		return "<html><h1>Je t'aime bb LAUREIN</h1></html>";
	}

//	@RequestMapping("/hello/{name}")
//	public String helloName(@PathVariable("name") String name) {
//		return "Hello " + name;
//	}

	@RequestMapping("/navires")
	public ResponseEntity<Collection<Navire>> navires() {
		Collection<Navire> navires = navireManager.getAllNavires();

//		if (navires == null || navires.size() == 0) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
		return new ResponseEntity<>(navires, HttpStatus.OK);
	}

	@RequestMapping(value = "/navire/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Navire> create(@RequestBody Navire navire) {
		navire = navireManager.create(navire);
		return new ResponseEntity<>(navire, HttpStatus.OK);
	}

}
