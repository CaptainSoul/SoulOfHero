package UI.common;

import dsa.iface.IIterator;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import map.Map;

public class SpriteUI extends Parent {
	public enum Direction {
		Left, Right, Up, Down
	};
	
	private Direction direction = Direction.Left;
	private Direction lastDirection;
	private int width;
	private int height;
	private int index = 0;
	private int indexDiv = 5;
	private ImageView mImageView;
	private double speed = 8;
	private int column = 4;

	
	public SpriteUI(int x, int y, int width, int height, String url) {
		this.width = width;
		this.height = height;
		Image actor = new Image(getClass().getResourceAsStream(url));
		mImageView = new ImageView(actor);
		mImageView.setViewport(new Rectangle2D(0, 0, width, height));
		mImageView.setLayoutX(x);
		mImageView.setLayoutY(y);
		getChildren().add(mImageView);
	}
	
	public void setIcon(String url) {
		Image actor = new Image(getClass().getResourceAsStream(url));
		getChildren().remove(mImageView);
		mImageView = new ImageView(actor);
		mImageView.setViewport(new Rectangle2D(0, 0, width, height));
		getChildren().add(mImageView);
	}

	public boolean isCollisionWith(double x, double y) {
		if (x > getX() && y > getY() && x < getX() + getWidth() && y < getX() + getHeight()) {
			return true;
		}
		return false;
	}
	
	public void moveDown(IIterator<Map> layers) {
		direction = Direction.Down;
		if(lastDirection != direction) {
			index = 0;
		}
		index++;
		if(index / indexDiv == column) {
			index = 0;
		}
		mImageView.setViewport(new Rectangle2D(((index / indexDiv) % column) * width, ((index / indexDiv) / column) * height, width,
				height));
		layers.next();
		boolean canMove = true;
		while(layers.hasNext()) {
			Map layer = layers.next();
			int[][] index = layer.getMapIndex();
			int xLeft = (int) ((getX() + speed) / (Map.tileWidth));
			int xRight = (int) ((getX() + width - speed) / (Map.tileWidth));
			int y = (int) ((getY() + height) / (Map.tileHeight));
			if((index[y][xLeft] != 0 || index[y][xRight] != 0))
				canMove = false;
		}
		if(canMove)
			mImageView.setLayoutY(getY() + speed);
		lastDirection = direction;
	}
	
	public void moveLeft(IIterator<Map> layers) {
		direction = Direction.Left;
		if(lastDirection != direction) {
			index = column * indexDiv;
		}
		index++;
		if(index / indexDiv == column * 2) {
			index = column * indexDiv;
		}
		mImageView.setViewport(new Rectangle2D(((index / indexDiv) % column) * width, ((index / indexDiv) / column) * height, width,
				height));
		layers.next();
		boolean canMove = true;
		while(layers.hasNext()) {
			Map layer = layers.next();
			int[][] index = layer.getMapIndex();
			int x = (int) (getX() / (Map.tileWidth));
			int y = (int) ((getY() + height - speed) / (Map.tileHeight));
			if(index[y][x] != 0)
				canMove = false;
		}
		if(canMove)
			mImageView.setLayoutX(getX() - speed);
		lastDirection = direction;
	}
	
	public void moveRight(IIterator<Map> layers) {
		direction = Direction.Right;
		if(lastDirection != direction) {
			index = column * 2 * indexDiv;
		}
		index++;
		if(index / indexDiv == column * 3) {
			index = column * 2 * indexDiv;
		}
		mImageView.setViewport(new Rectangle2D(((index / indexDiv) % column) * width, ((index / indexDiv) / column) * height, width,
				height));
		layers.next();
		boolean canMove = true;
		while(layers.hasNext()) {
			Map layer = layers.next();
			int[][] index = layer.getMapIndex();
			int x = (int) (getX() / (Map.tileWidth));
			int y = (int) ((getY() + height - speed) / (Map.tileHeight));
			if(index[y][x+1] != 0)
				canMove = false;
		}
		if(canMove)
			mImageView.setLayoutX(getX() + speed);
		lastDirection = direction;
	}
	
	public void moveUp(IIterator<Map> layers) {
		direction = Direction.Up;
		if(lastDirection != direction) {
			index = column * 3 * indexDiv;
		}
		index++;
		if(index / indexDiv == column * 4) {
			index = column * 3 * indexDiv;
		}
		mImageView.setViewport(new Rectangle2D(((index / indexDiv) % column) * width, ((index / indexDiv) / column) * height, width,
				height));
		layers.next();
		boolean canMove = true;
		while(layers.hasNext()) {
			Map layer = layers.next();
			int[][] index = layer.getMapIndex();
			int xLeft = (int) ((getX() + speed) / (Map.tileWidth));
			int xRight = (int) ((getX() + width - speed) / (Map.tileWidth));
			int y = (int) ((getY() + height - Map.tileHeight) / (Map.tileHeight));
			if(index[y][xLeft] != 0 || index[y][xRight] != 0)
				canMove = false;
		}
		if(canMove)
			mImageView.setLayoutY(getY() - speed);
		lastDirection = direction;
	}
	
	public double getX() {
		return mImageView.getLayoutX();
	}
	
	public void setX(double x) {
		mImageView.setLayoutX(x);
	}
	
	public double getY() {
		return mImageView.getLayoutY();
	}
	
	public void setY(double y) {
		mImageView.setLayoutY(y);
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public Direction getDirection() {
		return direction;
	}
}
