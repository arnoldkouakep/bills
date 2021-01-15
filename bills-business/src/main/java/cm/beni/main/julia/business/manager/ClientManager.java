package cm.beni.main.julia.business.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.master.ClientRepository;
import cm.beni.main.julia.model.schema.dossiers.Client;

@Component
public class ClientManager {

//	@Autowired
	private Client client;

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private PersonnalManager personnalManager;

	public Client create(Client client) {
		if (client.getPersonnal().getIdentify() == null) {
			client.setPersonnal(personnalManager.create(client.getPersonnal()));
		} else {
			client.setPersonnal(personnalManager.update(client.getPersonnal()));
		}

		client.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.client = client;
		clientRepository.save(this.client);
		return this.client;
	}

	public Client update(Client client) {
		if (client.getPersonnal().getIdentify() == null) {
			client.setPersonnal(personnalManager.create(client.getPersonnal()));
		} else {
			client.setPersonnal(personnalManager.update(client.getPersonnal()));
		}

		this.client = client;
		clientRepository.save(this.client);
		return this.client;
	}

	public Collection<Client> getAllClients() {
		return clientRepository.findAll();
	}

	public Collection<Client> getClientByPersonnalCode(String code) {
		return clientRepository.getClientByPersonnalCode(code);
	}

}
