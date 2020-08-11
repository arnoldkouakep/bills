package cm.beni.main.julia.business.controller;

import java.util.UUID;

public class BusinessController {

	public static String generateUIDPrimaryKey() {
		String idKey = "K_";
		return idKey + UUID.randomUUID();// new UID().toString();
	}

}
