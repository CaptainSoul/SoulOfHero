package map;

public class Exit {

	private Direction direction;

	private Location destination;

	public Exit(Direction direction, Location destination) {
		this.direction = direction;
		this.destination = destination;
	}

	public Direction getDirection() {
		return direction;
	}

	public Location getDestination() {
		return destination;
	}

}
