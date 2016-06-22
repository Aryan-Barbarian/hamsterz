package location;

/**
 * Created by aryan on 6/21/2016.
 */
public enum Direction {
    NORTH, SOUTH, WEST, EAST;

    public static Direction turnClockwise(Direction current) {
        switch (current) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
            default:
                return null;
        }
    }

    public static Direction turnCounterClockwise(Direction current) {
        switch (current) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            case EAST:
                return NORTH;
            default:
                return null;
        }
    }
}
