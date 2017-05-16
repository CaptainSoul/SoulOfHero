package dsa.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class WPath {
	private WLevelList levelList;
	private LinkedList<WNode> closeList;
	private int[][] map;
	public int[][] map_sprite; 
    public HashMap<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
	
	public WPath(int[][] map) {
		this.map = map;
		levelList = new WLevelList();
		closeList = new LinkedList<WNode>();
	}

	public LinkedList<WNode> SearchPath(Point2D start, Point2D end) {
		WNode _start = new WNode(start);
		WNode _end = new WNode(end);

		_start.setValueG(0);
		_start.setValueH(_start.getValue(_end));
		// Console.WriteLine("getValue()" + "==" + _start.getValue(_end));
		_start.setParent(null);
		levelList.add(_start);
		int ok = 0;
		while (levelList.size() > 0 && ok < 50) {
			ok++;
			WNode first = (WNode) levelList.toArray()[0]; 
			System.out.println("start searching:" + first.getPoint() + "," + _end.getPoint());
			levelList.remove(0);

			if (first.equals(_end))
				return makePath(first);
			else {
				closeList.addLast(first);
				LinkedList<WNode> limit = first.getNearNodeList();
				for (int i = 0; i < limit.size(); i++) {
					WNode nearWNode = limit.get(i);
					double x = nearWNode.getPoint().getX();
					double y = nearWNode.getPoint().getY();
					boolean isOpen = levelList.contains(nearWNode);
					boolean isClose = closeList.contains(nearWNode);
					boolean isHit = isHit((int) x, (int) y, _end);
					// Console.WriteLine(isOpen + "," + isClose + "," + isHit);
					// Console.WriteLine("nearWNode.point.X=" +
					// nearWNode.point.X + "nearWNode.point.Y=" +
					// nearWNode.point.Y);
					if (!isOpen && !isClose && !isHit) {
						try {
							int valueG = valueMap.get(map[(int)y][(int)x]);
							nearWNode.setValueG(first.getValueG() + valueG);
						} catch (Exception e) {
							nearWNode.setValueG(first.getValueG() + 1);
						}
						nearWNode.setValueH(nearWNode.getValue(_end));
						nearWNode.setParent(first);
						levelList.add(nearWNode);
					}
				}
			}
		}
		System.out.println("searching failure:");
		levelList.clear();
		closeList.clear();
		return null;
	}

	public LinkedList<WNode> SearchMoveScan(Point2D location, int step) {
		WNode start = new WNode(location);
		start.setValueG(0);
		start.setParent(null);
		levelList.add(start);
		closeList.addFirst(start);
		while (levelList.size() > 0) {
			WNode near = (WNode) levelList.toArray()[0];
			levelList.remove(0);
			LinkedList<WNode> nearList = near.getNearNodeList();
			addMoveWNode(nearList, start, near, step);  
		}
		return closeList;
	}

	public void addMoveWNode(LinkedList<WNode> near, WNode start, WNode before, int step) 
	{
		for (int i = 0; i < near.size(); i++) {
			WNode nearWNode = near.get(i);
			double x = nearWNode.getPoint().getX();
			double y = nearWNode.getPoint().getY();
			try {
				/*
				int valueG = valueMap.get(map[(int)y][(int)x]);				
				nearWNode.setValueG(before.getValueG() + valueG);*/
                switch (map[(int)y][(int)x])
                {
                    case 0:
                    	nearWNode.setValueG(before.getValueG() + 1);
                        break;
                    case 7:
                    	nearWNode.setValueG(before.getValueG() + 4);
                        break;
                    case 18:
                    	nearWNode.setValueG(before.getValueG() + 2);
                        break;
                }
			} catch (Exception e) {
				nearWNode.setValueG(before.getValueG() + 1);
			}
			boolean isOpen = contains(levelList, nearWNode);
			boolean isClose = contains(closeList, nearWNode);
			boolean isHit = isHit((int) nearWNode.getPoint().getX(), (int) nearWNode.getPoint().getY());
			// Console.WriteLine("isOpen isClose isHit" +
			// isOpen+","+isClose+","+isHit);
			if (!isOpen && !isClose && !isHit && nearWNode.getValueG() <= step) {
				levelList.addM(nearWNode);
				closeList.addFirst(nearWNode);
			}
		}
	}

	public boolean isHit(int x, int y) {
		// Console.WriteLine("x,y" + x + "," + y);
		// Console.WriteLine("map_canmove"+map_sprite[y,x]);
		if (map_sprite != null) {
			if (map_sprite[y][x] != 0)
				return true;
		}
		return false;
	}

	public boolean isHit(int x, int y, WNode end) {
		// Console.WriteLine("x,y" + x + "," + y);
		// Console.WriteLine("map_canmove"+map_sprite[y,x]);
		if (map_sprite != null) {
			if (map_sprite[y][x] != 0)
				return true;
		}
		return false;
	}

	public boolean contains(LinkedList<WNode> list, WNode WNode) {
		for (int i = 0; i < list.size(); i++) { 
			if (WNode.getPoint().getX() == list.get(i).getPoint().getX() && WNode.getPoint().getY() == list.get(i).getPoint().getY())
				return true;
		}
		return false;

	}

	public boolean contains(ArrayList<WNode> list, WNode WNode) {
		for (int i = 0; i < list.size(); i++) {
			if (WNode.getPoint().getX() == ((WNode) list.toArray()[i]).getPoint().getX()
					&& WNode.getPoint().getY() == ((WNode) list.toArray()[i]).getPoint().getY())
				return true;
		}
		return false;
	}

	public LinkedList<WNode> makePath(WNode WNode) {
		LinkedList<WNode> path = new LinkedList<WNode>();
		while (WNode.getParent() != null) {
			path.addFirst(WNode);
			WNode = WNode.getParent();
		}
		path.addFirst(WNode);
		return path;
	}

	public void clear() {
		levelList.clear();
		closeList.clear();
	}
}
