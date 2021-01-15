package cm.beni.main.julia.business.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cm.beni.main.julia.business.controller.BusinessController;
import cm.beni.main.julia.dao.controller.repository.julia.LevelRepository;
import cm.beni.main.julia.model.schema.security.Level;

@Component
public class LevelManager {

//	@Autowired
	private Level level;

	@Autowired
	private LevelRepository levelRepository;

	public LevelManager() {
		super();
	}
	
	public Level create(Level level) {
		level.setIdentify(BusinessController.generateUIDPrimaryKey());
		this.level = level;
		this.levelRepository.save(this.level);
		return this.level;
	}

	public Level update(Level level) {
		this.level = level;
		this.levelRepository.save(this.level);
		return this.level;
	}

	public Level getLevelByCode(String code) {
		level = levelRepository.getLevelByCode(code);
		return level;
	}

}
