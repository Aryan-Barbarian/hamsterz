package actor;

import brain.Brain;
import core.Game;
import core.World;
import location.Direction;
import location.Grid;
import location.GridLocation2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aryan on 6/17/2016.
 */
public class  Actor extends Entity {

    private Game game;
    private World world;
    private Grid<GridLocation2D> grid;
    private Direction direction;
    private Brain brain;

    public Actor(Game game, World world, Grid grid) {
        super(game, world, grid);
        this.game = game;
        this.world = world;
        this.grid = grid;
        this.direction = Direction.NORTH;
    }

    public void act() {
//        TODO: Move actor code into other classes for better modularity.
//        Action action = getAction(); // TODO: Get rid of this for performance reasons?
        // Create Gamestate TODO: this will be more official later
        List<Action> legalMoves = this.getLegalMoves();
        Action chosenMove = this.brain.getAction(legalMoves);
        this.handleAction(chosenMove);
    }

    public List<Action> getLegalMoves() {
        List<Action> ans = new ArrayList<Action>();
        return ans;
    }


    public World getWorld() {
        return world;
    }

    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        this.brain = brain;
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
