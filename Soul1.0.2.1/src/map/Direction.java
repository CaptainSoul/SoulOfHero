package map;

public enum Direction {
	NORTH(0), SOUTH(1), WEST(2), EAST(3);
	public final int index;
	private Direction(int i) {
		index = i;
	}

}
