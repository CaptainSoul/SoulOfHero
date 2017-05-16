package dsa.impl;

import java.util.LinkedList;

public class WNode {
	private Point2D point;
	private double valueG;
	private double valueH;
	private WNode parent;

	public WNode() {
	}

	public WNode(Point2D point) {
		this.point = point;
	}

	public int compareToNode(WNode node) {
		if (valueG + valueH > node.valueG + node.valueH)
			return 1;
		else if (valueG + valueH == node.valueG + node.valueH)
			return 0;
		return -1;
	}

	public double getValue(WNode node) {
		double x = point.getX() - node.point.getX();
		double y = point.getY() - node.point.getY();
		return Math.abs(x) + Math.abs(y);
	}

	public boolean equals(WNode node) {
		if (point.getX() == node.point.getX() && point.getY() == node.point.getY())
			return true;
		return false;
	}

	public LinkedList<WNode> getNearNodeList() {
		LinkedList<WNode> list = new LinkedList<WNode>();
		double x = point.getX();
		double y = point.getY();

		list.addFirst(new WNode(new Point2D(x, y - 1)));
		list.addFirst(new WNode(new Point2D(x - 1, y)));
		list.addFirst(new WNode(new Point2D(x + 1, y)));
		list.addFirst(new WNode(new Point2D(x, y + 1)));
		return list;
	}

	public Point2D getPoint() {
		return point;
	}

	public void setPoint(Point2D point) {
		this.point = point;
	}

	public double getValueG() {
		return valueG;
	}

	public void setValueG(double valueG) {
		this.valueG = valueG;
	}

	public double getValueH() {
		return valueH;
	}

	public void setValueH(double valueH) {
		this.valueH = valueH;
	}

	public WNode getParent() {
		return parent;
	}

	public void setParent(WNode parent) {
		this.parent = parent;
	}
}