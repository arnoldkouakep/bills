package cm.beni.main.julia.service;

import org.springframework.stereotype.Component;

@Component
public class MainService {

	public String hello() {
		return "Hello World";
	}

	public String helloName(String name) {
		return "Bonjour " + name;
	}
}
