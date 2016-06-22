package actor;

import core.Game;
import core.World;
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

    public Actor(Game game, World world, Grid grid) {
        this.game = game;
        this.world = world;
        this.grid = grid;
    }

    public void act() {
        Action action = getAction();
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
                //
                break;
            case TURN_RIGHT:
                //
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
}
