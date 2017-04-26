package dsa.impl;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Point2D{
	private DoubleProperty x = new SimpleDoubleProperty(0);
	private DoubleProperty y = new SimpleDoubleProperty(0);

	public Point2D(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public double getX() {
		return x.get();
	}

	public DoubleProperty xDoubleProperty(){
		return x;
	}
	public void setX(double x) {
		this.x.set(x);
	}

	public double getY() {
		return y.get();
	}
	
	public DoubleProperty yDoubleProperty(){
		return y;
	}

	public void setY(double y) {
		this.y.set(y);
	}
	
	public void add(double x,double y){
		setX(this.x.get() + x);
		setY(this.y.get() + y);
	}
	
	public void add(Point2D point2d){
		add(point2d.getX(), point2d.getY());
	}
	
	public String toString(){
		return "X:" + x + ",Y:" + y;
	}
}
