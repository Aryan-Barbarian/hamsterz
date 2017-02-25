package actor;

import core.Game;
import core.World;
import location.Grid;

/**
 * Created by Aryan on 2/25/2017.
 */
public class Person extends Actor {


    public Person(World world, Grid grid) {
        super(world, grid);
    }

    @Override
    public String getName() {
        return "person";
    }
}
