package cm.beni.main.julia.dao.controller.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.beni.main.julia.model.schema.dossiers.Personnal;

public interface PersonnalRepository extends JpaRepository<Personnal, Long> {

}
