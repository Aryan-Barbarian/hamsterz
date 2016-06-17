import location.Grid;
import location.GridLocation;
import location.Gridable;

/**
 * Created by aryan on 6/17/2016.
 */
public class Actor implements Gridable {

    private Game game;
    private World world;
    private Grid grid;

    public Actor(Game game, World world, Grid grid) {
        this.game = game;
        this.world = world;
        this.grid = grid;
    }

    public Action getAction(World world) {
        return Action.DO_NOTHING;
    }

    public float utility(World world) {
        return 0;
    }

    @Override
    public GridLocation getLocation() {
        return grid.locationOf(this);
    }
}
