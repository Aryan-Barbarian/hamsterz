package actor;

import core.Game;
import core.World;
import location.Direction;
import location.Grid;
import location.GridLocation2D;
import location.Gridable;

/**
 * Created by aryan on 6/17/2016.
 */
public class Actor implements Gridable {

    private Game game;
    private World world;
    private Grid<GridLocation2D> grid;
    private Direction direction;

    public Actor(Game game, World world, Grid grid) {
        this.game = game;
        this.world = world;
        this.grid = grid;
        this.direction = Direction.NORTH;
    }

    public void act() {
        Action action = getAction(); // TODO: Get rid of this for performance reasons?
    }

    public Action getAction() {
        return Action.DO_NOTHING;
    }

    public World getWorld() {
        return world;
    }

    public void handleAction(Action action) {
        GridLocation2D loc = getLocation();
        boolean moved = false;
        int newX = loc.x;
        int newY = loc.y;

        switch (action) {
            case MOVE_FORWARD:
                newX = loc.x;
                newY = loc.y + 1;
                moved = true;
                break;
            case MOVE_BACK:
                newX = loc.x;
                newY = loc.y - 1;
                moved = true;
                break;
            case MOVE_LEFT:
                newX = loc.x - 1;
                newY = loc.y;
                moved = true;
                break;
            case MOVE_RIGHT:
                newX = loc.x + 1;
                newY = loc.y;
                moved = true;
                break;
            case TURN_LEFT:
                if (this.direction.equals(Direction.NORTH))
                    this.direction = Direction.WEST;
                if (this.direction.equals(Direction.WEST))
                    this.direction = Direction.SOUTH;
                if (this.direction.equals(Direction.SOUTH))
                    this.direction = Direction.EAST;
                if (this.direction.equals(Direction.EAST))
                    this.direction = Direction.NORTH;
                break;
            case TURN_RIGHT:
                if (this.direction.equals(Direction.NORTH))
                    this.direction = Direction.EAST;
                if (this.direction.equals(Direction.WEST))
                    this.direction = Direction.NORTH;
                if (this.direction.equals(Direction.SOUTH))
                    this.direction = Direction.WEST;
                if (this.direction.equals(Direction.EAST))
                    this.direction = Direction.SOUTH;
                break;
            case EAT:
                //
                break;
            case DIE:
                //
                break;
            case DO_NOTHING:
                //
                break;
            case DEFEND:
                //
                break;
            default:
                //
                break;
        }

        if (moved) {
            GridLocation2D newLoc = GridLocation2D.getLocation(newX, newY);
            grid.move(this, loc, newLoc);
        }
    }

    public float utility(World world) {
        return 0;
    }

    @Override
    public GridLocation2D getLocation() {
        return grid.locationOf(this);
    }

    @Override
    public Direction getDirection() {
        return Direction.NORTH;
    }
}
