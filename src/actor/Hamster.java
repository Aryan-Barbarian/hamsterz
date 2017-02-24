package actor;

import core.Game;
import core.World;
import location.Direction;
import location.Grid;
import location.GridLocation2D;

/**
 * Created by aryan on 6/17/2016.
 */
public class Hamster extends Actor {

    private int food;

    public Hamster(Game game, World world, Grid grid) {
        super(game, world, grid);
        this.food = 0;
    }

    public void act() {
        super.act();
        food -= 1;
    }


}
