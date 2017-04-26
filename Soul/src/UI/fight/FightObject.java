package UI.fight;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import UI.BaseObject;
import character.Sprite;
import dsa.impl.Point2D;
import dsa.impl.WNode;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

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
	public LinkedList<WNode> nodeList;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		setWidth(FightCanvas.tileWidth);
		setHeight(FightCanvas.tileHeight);
	}
	
	public void draw(GraphicsContext gc) {
		gc.save();
		if (image != null) {
			if (isCanAction) {
				if (isFlash) {
					if (startCount < flashCount) {
						gc.setGlobalAlpha(0.3f);
						gc.setFill(Color.RED);
						gc.fillRect(getX(), getY(), width, height);
						startCount ++ ;
					} else {
						startCount = 0;
						isFlash = false;
					}
				}
				gc.setGlobalAlpha(1.0f);
				gc.drawImage(image, x, y, 32, 32);
			} else {
				gc.setGlobalAlpha(0.5f);
				gc.drawImage(image, x, y, 32, 32);
			}
			gc.setGlobalAlpha(1.5f);
			if (isChoose) {
				gc.strokeRect(x, y, 32, 32);
				if (nodeList != null && isWaitToMove) {
					for (Iterator<WNode> node = nodeList.iterator(); node.hasNext();) {
						WNode wNode = node.next();
						int drawX = (int) (wNode.getPoint().getX() * width);
						int drawY = (int) (wNode.getPoint().getY() * height);
						if (!(drawX == getX() && drawY == getY())) {
							gc.setGlobalAlpha(0.5f);
							gc.fillRect(drawX, drawY, width, height);
						}
					}
				}
				if (isWaitToAttack) {
					int nodeX = (int) (getX() / width);
					int nodeY = (int) (getY() / height);
					gc.setFill(Color.RED);
					gc.setGlobalAlpha(0.5f);
					gc.fillRect((nodeX - 1) * width, nodeY * height, width, height);
					gc.fillRect((nodeX + 1) * width, nodeY * height, width, height);
					gc.fillRect(nodeX * width, (nodeY - 1) * height, width, height);
					gc.fillRect(nodeX * width, (nodeY + 1) * height, width, height);
				}
			}
		}
		gc.restore();
	}

	/**
	 * 寻找离自己最近的节点
	 * 
	 * @param nodes
	 *            节点链表
	 * @return 最近的节点
	 */
	public Point2D getNearestNode(LinkedList<WNode> nodes) {
		Point2D basePoint = new Point2D(x, y);
		for (int i = 0; i < nodes.size(); i++) {
			WNode node = nodes.get(i);
			if (Math.abs(getX() / width - basePoint.getX()) + Math.abs(getY() / height - basePoint.getY()) > Math
					.abs(getX() / width - node.getPoint().getX()) + Math.abs(getY() / height - node.getPoint().getY())) {
				basePoint = node.getPoint();
			}
		}
		return basePoint;
	}
	
	public void flash() {
		isFlash = true;
		startCount = 0;
	}
	
	public boolean isHasNearBP(List<Sprite> players) {
		int mx = (int) (getX() / width);
		int my = (int) (getY() / height);
		for (Sprite bp : players) {
			int x = (int) (bp.getX() / width);
			int y = (int) (bp.getY() / height);
			if ((x == mx && y == my + 1) || (x == mx - 1 && y == my) || (x == mx + 1 && y == my)
					|| (x == mx && y == my - 1)) {
				return true;
			}
		}
		return false;
	}
	
	public Sprite getNearestBP(List<Sprite> players) {
		Sprite basePlayer = players.get(0);
		for (int i = 0; i < players.size(); i++) {
			Sprite player = players.get(i);
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
