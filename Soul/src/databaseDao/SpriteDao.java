package databaseDao;

import character.Sprite;

public interface SpriteDao {
	public void addSprite ( Sprite sprite);
	public Sprite getSprite ( int code );
	public int update ( Sprite sprite);
	public int delete ( Sprite sprite);
}
