package character;

import java.util.List;

import UI.BaseObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import map.MapCanvas;

public class FightObject extends BaseObject {
	private Image image;
	private boolean isChoose = false;
	private boolean isWaitToAttack = false;
	private boolean isWaitToMove = false;
	private boolean isCanAction = true;
	private boolean isCanMove = true;
	private boolean isCanAttack = true;
	
	private int flashCount = 10;
	private int startCount = 10;
	private boolean isFlash = false;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		setWidth(MapCanvas.tileWidth);
		setHeight(MapCanvas.tileHeight);
	}
	
	public void draw(GraphicsContext gc) {
		gc.save();
		if(image != null) {
			if(isCanAction) {
				if(isFlash) {
					if(startCount < flashCount) {
						gc.setGlobalAlpha(0.3f);
						gc.setFill(Color.RED);
						gc.fillRect(getX(), getY(), width, height);
					} else {
						startCount = 0;
						isFlash = false;
					}
				}
				gc.setGlobalAlpha(1.0f);
				gc.drawImage(image, x, y, width, height);
			} else {
				gc.setGlobalAlpha(0.5f);
				gc.drawImage(image, x, y, width, height);
			}
			gc.setGlobalAlpha(1.5f);
			if(isChoose) {
				gc.strokeRect(x, y, 32, 32);
			}
		}
		gc.restore();
	}
	
	public void flash() {
		isFlash = true;
		startCount = 0;
	}
	
	public boolean isHasNearBP(List<AbstractCharacter> players) {
		int mx = (int) (getX() / width);
		int my = (int) (getY() / height);
		for (AbstractCharacter bp : players) {
			int x = (int) (bp.getX() / width);
			int y = (int) (bp.getY() / height);
			if ((x == mx && y == my + 1) || (x == mx - 1 && y == my) || (x == mx + 1 && y == my)
					|| (x == mx && y == my - 1)) {
				return true;
			}
		}
		return false;
	}
	
	public AbstractCharacter getNearestBP(List<AbstractCharacter> players) {
		AbstractCharacter basePlayer = players.get(0);
		for (int i = 0; i < players.size(); i++) {
			AbstractCharacter player = players.get(i);
			if (Math.abs(getX() - basePlayer.getX()) + Math.abs(getY() - basePlayer.getY()) > Math.abs(getX()
					- player.getX())
					+ Math.abs(getY() - player.getY())) {
				basePlayer = player;
			}
		}
		return basePlayer;
	}
	
	public boolean isCollisionWith(double x, double y) {
		if (x > getX() && y > getY() && x < getX() + getWidth() && y < getY() + getHeight()) {
			return true;
		}
		return false;
	}
	
	public boolean isChoose() {
		return isChoose;
	}

	public void setChoose(boolean isChoose) {
		this.isChoose = isChoose;
	}
	
	public boolean isWaitToAttack() {
		return isWaitToAttack;
	}

	public void setWaitToAttack(boolean isWaitToAttack) {
		this.isWaitToAttack = isWaitToAttack;
	}

	public boolean isWaitToMove() {
		return isWaitToMove;
	}

	public void setWaitToMove(boolean isWaitToMove) {
		this.isWaitToMove = isWaitToMove;
	}
	
	public boolean isCanAction() {
		return isCanAction;
	}

	public void setCanAction(boolean isCanAction) {
		this.isCanAction = isCanAction;
	}

	public boolean isCanMove() {
		return isCanMove;
	}

	public void setCanMove(boolean isCanMove) {
		this.isCanMove = isCanMove;
	}

	public boolean isCanAttack() {
		return isCanAttack;
	}

	public void setCanAttack(boolean isCanAttack) {
		this.isCanAttack = isCanAttack;
	}

	public boolean isFlash() {
		return isFlash;
	}

	public void setFlash(boolean isFlash) {
		this.isFlash = isFlash;
	}
	
	public void reset() {
		isChoose = false;
		isWaitToAttack = false;
		isWaitToMove = false;
		isCanAction = true;
		isCanMove = true;
		isCanAttack = true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
