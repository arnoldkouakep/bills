package cm.beni.main.julia.dao.controller.repository.julia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.beni.main.julia.model.schema.security.Level;

public interface LevelRepository extends JpaRepository<Level, Long> {

	@Query("FROM Level WHERE code=:code")
	Level getLevelByCode(@Param("code") String code);

}
