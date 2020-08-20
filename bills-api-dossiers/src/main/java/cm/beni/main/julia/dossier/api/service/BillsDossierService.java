package cm.beni.main.julia.dossier.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/dossier")
public class BillsDossierService {

	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
}
