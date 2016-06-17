import location.Grid;

/**
 * Created by aryan on 6/17/2016.
 */
public class ZombieGerbil extends Actor {
    public ZombieGerbil(Game game, World world, Grid grid) {
        super(game, world, grid);
    }

    @Override
    public Action getAction(World world) {
        return Action.MOVE_FORWARD;
    }
}
