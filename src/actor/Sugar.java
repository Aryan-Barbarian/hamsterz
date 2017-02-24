package actor;

import core.Game;
import core.World;
import location.Grid;

/**
 * Created by aryan on 6/17/2016.
 */
public class Sugar extends Actor {

    private int supply;

    public Sugar(Game game, World world, Grid grid) {
        super(game, world, grid);
        supply = 250;
    }

    public void beEaten(int amount) {
        supply -= amount;
    }


}
