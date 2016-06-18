package actor;

import core.Game;
import core.World;
import location.Grid;

/**
 * Created by aryan on 6/17/2016.
 */
public class Hamster extends Actor {
    private int food;

    public Hamster(Game game, World world, Grid grid) {
        super(game, world, grid);
        food = 100;
    }

    @Override
    public void act() {
        super.act();
        food -= 1;
    }
}
