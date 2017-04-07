package map;

public enum Direction {
	NORTH(0), SOUTH(1), WEST(2), EAST(3);
	private final int code;
	private Direction(int i) {
		code = i;
	}
	
	public int getCode() {
		return code;
	}

}
