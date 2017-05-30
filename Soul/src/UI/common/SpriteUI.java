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
	private int indexDiv = 2;
	private ImageView mImageView;
	private double speed = 10;
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
	
	public boolean isCollisionWithTile(int x, int y) {
		if(isCollisionWith(2 * x * Map.tileWidth - 2*speed, 2* y * Map.tileHeight - 2*speed)
				|| isCollisionWith(2 * (x+1) * Map.tileWidth + 2*speed, 2* y * Map.tileHeight - 2*speed)
				|| isCollisionWith(2 * x * Map.tileWidth + 2*speed, 2* (y+1) * Map.tileHeight + 2*speed)
				|| isCollisionWith(2 * (x+1) * Map.tileWidth + 2*speed, 2* (y+1) * Map.tileHeight + 2*speed))
			return true;
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
			int x = (int) (mImageView.getLayoutX() / (Map.tileWidth)) + 1;
			int y = (int) (mImageView.getLayoutY() / (Map.tileHeight)) + 1;
			System.out.println("x:" + x);
			System.out.println("y:" + y);
		/*	if(mImageView.getLayoutY() - height + 3*speed >=  y * Map.tileHeight
					&& mImageView.getLayoutX() > x * Map.tileWidth
					&& mImageView.getLayoutX() <  (x+1) * Map.tileWidth
					&& index[y+1][x] != 0)*/
			if(getY() + height <= y * Map.tileHeight &&
					(getX() >= x * Map.tileWidth || getX() + width >= x * Map.tileWidth) &&
					(getX()<= (x+1) * Map.WIDTH || getX() + width <= (x+1 * Map.tileWidth)))
				canMove = false;
			System.out.println(mImageView.getLayoutX() + speed + getWidth());
			System.out.println(2 * (y-1) * Map.tileWidth);
		}
		if(canMove)
			mImageView.setLayoutY(mImageView.getLayoutY() + speed);
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
			int x = (int) (mImageView.getLayoutX() / (Map.tileWidth));
			int y = (int) (mImageView.getLayoutY() / (2*Map.tileHeight));
			if(mImageView.getLayoutX() - speed <=  (x+1) * Map.tileWidth
					&& mImageView.getLayoutY() + 3*speed >  y * Map.tileHeight
					&& mImageView.getLayoutY() + height - 2*speed <  (y+1) * Map.tileHeight
					&& index[y][x] != 0)
				canMove = false;
			System.out.println(mImageView.getLayoutX() - speed);
			System.out.println(2 * x * Map.tileWidth);
		}
		if(canMove)
			mImageView.setLayoutX(mImageView.getLayoutX() - speed);
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
			int x = (int) (mImageView.getLayoutX() / (Map.tileWidth));
			int y = (int) (mImageView.getLayoutY() / (Map.tileHeight));
			System.out.println("x:" + x);
			System.out.println("y:" + y);
			if(mImageView.getLayoutX() + width + speed>= (x+1) * Map.tileWidth
					&& mImageView.getLayoutY() + 3*speed > y * Map.tileHeight
					&& mImageView.getLayoutY() + 3*speed <  (y+1) * Map.tileHeight
					&& index[y][x+1] != 0)

				canMove = false;
			System.out.println(mImageView.getLayoutX() + speed + getWidth());
			System.out.println(2 * (x+1) * Map.tileWidth);
		}
		if(canMove)
			mImageView.setLayoutX(mImageView.getLayoutX() + speed);
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
			int x = (int) (mImageView.getLayoutX() / (Map.tileWidth));
			int y = (int) (mImageView.getLayoutY() / (Map.tileHeight));
			System.out.println("x:" + x);
			System.out.println("y:" + y);
			if(mImageView.getLayoutY() - speed >= y * Map.tileHeight
					&& mImageView.getLayoutX() >  x * Map.tileWidth
					&& mImageView.getLayoutX() <  (x+1) * Map.tileWidth
					&& index[y][x] != 0)
				canMove = false;
			System.out.println(mImageView.getLayoutX() + speed + getWidth());
			System.out.println(2 * (y-1) * Map.tileWidth);
		}
		if(canMove)
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
