package UI;

import javafx.scene.canvas.GraphicsContext;

public abstract class BaseObject {
	protected double x, y;
	protected double width, height;
	protected boolean isVisible;
	
	public abstract void draw(GraphicsContext gContext);
	public abstract void update();
	
	public void moveX(double x) {
		setX(getX() + x);
	}
	
	public void moveY(double y) {
		setY(getY() + y);
	}
	
	public void move(double x, double y) {
		moveX(x);
		moveY(y);
	}
	
	public void setXY(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public boolean isCollisionWith(double x, double y) {
		if(x > getX() && y > getY() && x < getX() + getWidth() && y < getY() + getHeight()) {
			return true;
		}
		return false;
	}
	
	public boolean isVisible() {
		return isVisible();
	}
	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	
}
