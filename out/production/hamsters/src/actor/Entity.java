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

    private Game game;
    private World world;
    private Grid<GridLocation2D> grid;
    private Direction direction;
    private String name;


    public Entity(Game game, World world, Grid grid) {
        this.game = game;
        this.world = world;
        this.grid = grid;
        this.direction = Direction.NORTH;
    }

    public Entity(Game game, World world, Grid grid, String name) {
        this(game, world, grid);
        this.name = name;
    }

    public String getName() {
        return this.name;
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
}
