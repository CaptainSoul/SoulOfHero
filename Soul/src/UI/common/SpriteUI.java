package UI.common;

import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteUI extends Parent {
	private enum Direction {
		Left, Right, Up, Down
	};
	
	private Direction direction = Direction.Left;
	private Direction lastDirection;
	private int width;
	private int height;
	private int index = 0;
	private int indexDiv = 3;
	private ImageView mImageView;
	private int speed = 8;
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
	
	public boolean isCollisionWith(double x, double y) {
		if (x > mImageView.getLayoutX() && y > mImageView.getLayoutY() && x < mImageView.getLayoutX() + getWidth() && y < mImageView.getLayoutX() + getHeight()) {
			return true;
		}
		return false;
	}

	public void moveDown() {
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
		mImageView.setLayoutY(mImageView.getLayoutY() + speed);
		lastDirection = direction;
	}
	
	public void moveLeft() {
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
		mImageView.setLayoutX(mImageView.getLayoutX() - speed);
		lastDirection = direction;
	}
	
	public void moveRight() {
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
		mImageView.setLayoutX(mImageView.getLayoutX() + speed);
		lastDirection = direction;
	}
	
	public void moveUp() {
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
		mImageView.setLayoutY(mImageView.getLayoutY() - speed);
		lastDirection = direction;
	}
	
	public double getX() {
		return mImageView.getLayoutX();
	}
	
	public void setX(double x) {
		mImageView.getLayoutX();
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
}
