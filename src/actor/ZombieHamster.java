package actor;

import core.Game;
import core.World;
import location.Grid;

/**
 * Created by aryan on 6/17/2016.
 */
public class ZombieHamster extends Actor {
    public ZombieHamster(Game game, World world, Grid grid) {
        super(game, world, grid);
    }

    @Override
    public Action getAction() {
        return Action.MOVE_FORWARD;
    }
}
