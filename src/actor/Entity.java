package actor;

import core.Game;
import core.World;
import location.Direction;
import location.Grid;
import location.GridLocation2D;
import location.Gridable;

/**
 * Created by Aryan on 2/23/2017.
 */
public class Entity implements Gridable {

    private World world;
    private Grid<GridLocation2D> grid;
    private Direction direction;


    public Entity(World world, Grid grid) {
        this.world = world;
        this.grid = grid;
        this.direction = Direction.NORTH;
    }

    public String getName() {
        // TODO: allow for customizable names using an istance variable instead of a hardcoded method return.
        return "bush";
    }

    public World getWorld() {
        return world;
    }

    @Override
    public GridLocation2D getLocation() {
        return grid.locationOf(this);
    }

    @Override
    public Direction getDirection() {
        return Direction.NORTH;
    }

    public void handleAction(Action action) {
        // TODO: Move this into somewhere better, since this class isn't supposed to be responsible for actions
        GridLocation2D loc = this.getLocation();
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
                if (this.getDirection().equals(Direction.NORTH))
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

            // TODO: Add location damage and stuff
        }

    }
}
