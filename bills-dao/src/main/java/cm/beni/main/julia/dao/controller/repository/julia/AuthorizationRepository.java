package cm.beni.main.julia.dao.controller.repository.julia;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.beni.main.julia.model.schema.access.Authorization;


public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

}
