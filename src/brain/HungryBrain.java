package brain;

import actor.Action;
import actor.Entity;
import actor.Sugar;
import core.World;
import location.Direction;
import location.GridLocation2D;

import java.util.List;

/**
 * Created by Aryan on 2/24/2017.
 */
public class HungryBrain extends Brain{

    public HungryBrain(Entity entity) {
        super(entity);
    }

    @Override
    public Action getAction(List<Action> legalMoves) {
        Entity myEntity = this.getEntity();
        World world = myEntity.getWorld();
        GridLocation2D location = myEntity.getLocation();
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
        Entity myEntity = this.getEntity();
        GridLocation2D currLocation = myEntity.getLocation();
        float diffX = currLocation.x - goal.x;
        float diffY = currLocation.y - goal.y;
        Direction neededDir = this.directionToFace(diffX, diffY);
        Direction currDir = myEntity.getDirection();


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
