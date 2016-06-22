package actor;

import core.Game;
import core.World;
import location.Direction;
import location.Grid;
import location.GridLocation2D;

/**
 * Created by aryan on 6/17/2016.
 */
public class HungryHamster extends Hamster {

    public HungryHamster(Game game, World world, Grid grid) {
        super(game, world, grid);
    }

    @Override
    public Action getAction() {
        World world = this.getWorld();
        GridLocation2D location = this.getLocation();
        Sugar nearestSugar = world.closestSugar(location);

        if (nearestSugar == null) {
            return Action.DO_NOTHING;
        }
        GridLocation2D sugarLoc = nearestSugar.getLocation();

        if (this.canEat(location, sugarLoc)) {
            return Action.EAT;
        }

        return goTowards(sugarLoc);

    }

    private boolean canEat(GridLocation2D currLocation, GridLocation2D sugarLoc) {
        float dist = GridLocation2D.manhattanDistance(currLocation, sugarLoc);
        return ((dist <= 1.00000001) && (this.isFacing(sugarLoc)));
    }

    protected Action goTowards(GridLocation2D goal) {

        GridLocation2D currLocation = this.getLocation();
        float diffX = currLocation.x - goal.x;
        float diffY = currLocation.y - goal.y;
        Direction neededDir = this.directionToFace(diffX, diffY);
        Direction currDir = this.getDirection();


        if (!neededDir.equals(currDir)) {
            if (Direction.turnClockwise(currDir).equals(neededDir)) {
                return Action.TURN_RIGHT;
            } else {
                return Action.TURN_LEFT;
            }
        }

        return Action.MOVE_FORWARD;
    }

    protected Direction directionToFace(float diffX, float diffY) {
        if (diffX > 0.0000001) {
            return Direction.WEST;
        } else if (diffX < -0.0000001) {
            return Direction.EAST;
        }

        if (diffY > 0.0000001) {
            return Direction.NORTH;
        } else {
            return Direction.SOUTH;
        }
    }

    protected boolean isFacing(GridLocation2D goal) {
        return false;
    }
}
