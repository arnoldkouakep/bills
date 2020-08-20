package cm.beni.main.julia.dao.controller.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.beni.main.julia.model.schema.dossiers.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
