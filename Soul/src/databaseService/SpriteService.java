package databaseService;

import character.Sprite;
import databaseDao.DaoFactory;
import databaseDao.SpriteDao;

public class SpriteService {
	private SpriteDao spriteDao;
	
	public SpriteService(){
		spriteDao = DaoFactory.getInstace().createSpriteDao();
		System.out.println("spriteDao: " + spriteDao);
	}
	
	public void add(Sprite sprite) {
		if(sprite == null) {
			System.out.println("Invalid addition!!");
		} else {
			spriteDao.addSprite(sprite);
		}
	}
	
	public Sprite query(int code) {
		Sprite sprite = spriteDao.getSprite(code);
		if(sprite == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(sprite.toString());
		}
		return sprite;
	}
	
	public void update(Sprite sprite) {
		if(sprite.getCode() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			spriteDao.update(sprite);
		}
	}
	
	public void delete(Sprite sprite) {
		if(sprite.getCode() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			spriteDao.delete(sprite);
		}
	}
}
