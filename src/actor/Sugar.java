package actor;

import core.Game;
import core.World;
import location.Grid;

/**
 * Created by aryan on 6/17/2016.
 */
public class Sugar extends Actor {

    private int supply;

    public Sugar(World world, Grid grid) {
        super(world, grid);
        supply = 250;
    }

    public void beEaten(int amount) {
        supply -= amount;
    }

    @Override
    public String getName() {
        return "bush";
    }

}
