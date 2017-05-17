package UI.common;

import dsa.iface.IIterator;
import dsa.impl.SLinkedList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import map.Map;

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
	
	public boolean canMove(Direction dir, double x, double y) {
		switch(dir) {
			case Down:
				if(isCollisionWith(x,y - speed)) {
					System.out.println("no");
					return false;
				}
				return true;
			case Up:
				if(isCollisionWith(x,y + speed)) {
					System.out.println("no");
					return false;
				}
				return true;
			case Left:
				if(isCollisionWith(x + speed,y)) {
					System.out.println("no");
					return false;
				}
				return true;
			case Right:
				if(isCollisionWith(x - speed,y)) {
					System.out.println("no");
					return false;
				}
				return true;
		}
		return false;
	}
	
	public boolean isCollisionWith(double x, double y) {
		if (x > mImageView.getLayoutX() && y > mImageView.getLayoutY() && x < mImageView.getLayoutX() + getWidth() && y < mImageView.getLayoutX() + getHeight()) {
			return true;
		}
		return false;
	}

	public void moveDown(MainCanvas mainCanvas) {
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
		lastDirection = direction;
		IIterator<Map> layersIterator = mainCanvas.iterator();
		int[][][] index;
		while(layersIterator.hasNext()) {
			layersIterator.next();
			index = layersIterator.next().coordinate();
			for(int i = 1; i<index.length; i++) {
				for(int y = 0; y < Map.MAP_HEIGHT; y++) {
					for(int x = 0; x < Map.MAP_WIDTH; x++) {
						if(!canMove(direction, index[y][x][0], index[y][x][1]) && index[y][x][0] != 0 && index[y][x][1] != 0) {
							return ;
						}
					}
				}
			}
		}
		mImageView.setLayoutY(mImageView.getLayoutY() + speed);
	}
	
	public void moveLeft(MainCanvas mainCanvas) {
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
		lastDirection = direction;
		IIterator<Map> layersIterator = mainCanvas.iterator();
		int[][][] index;
		while(layersIterator.hasNext()) {
			layersIterator.next();
			index = layersIterator.next().coordinate();
			for(int i = 1; i<index.length; i++) {
				for(int y = 0; y < Map.MAP_HEIGHT; y++) {
					for(int x = 0; x < Map.MAP_WIDTH; x++) {
						if(!canMove(direction, index[y][x][0], index[y][x][1]) && index[y][x][0] != 0 && index[y][x][1] != 0) {
							return ;
						}
					}
				}
			}
		}
		mImageView.setLayoutX(mImageView.getLayoutX() - speed);
		
	}
	
	public void moveRight(MainCanvas mainCanvas) {
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
		lastDirection = direction;
		IIterator<Map> layersIterator = mainCanvas.iterator();
		int[][][] index;
		while(layersIterator.hasNext()) {
			layersIterator.next();
			index = layersIterator.next().coordinate();
			for(int i = 1; i<index.length; i++) {
				for(int y = 0; y < Map.MAP_HEIGHT; y++) {
					for(int x = 0; x < Map.MAP_WIDTH; x++) {
						if(!canMove(direction, index[y][x][0], index[y][x][1]) && index[y][x][0] != 0 && index[y][x][1] != 0) {
							return ;
						}
					}
				}
			}
		}
		mImageView.setLayoutX(mImageView.getLayoutX() + speed);
		
	}
	
	public void moveUp(MainCanvas mainCanvas) {
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
		lastDirection = direction;
		IIterator<Map> layersIterator = mainCanvas.iterator();
		int[][][] index;
		while(layersIterator.hasNext()) {
			layersIterator.next();
			index = layersIterator.next().coordinate();
			for(int i = 1; i<index.length; i++) {
				for(int y = 0; y < Map.MAP_HEIGHT; y++) {
					for(int x = 0; x < Map.MAP_WIDTH; x++) {
						if(!canMove(direction, index[y][x][0], index[y][x][1]) && index[y][x][0] != 0 && index[y][x][1] != 0) {
							return ;
						}
					}
				}
			}
		}
		mImageView.setLayoutY(mImageView.getLayoutY() - speed);
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
