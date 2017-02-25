package actor;

import core.Game;
import core.World;
import location.Grid;

/**
 * Created by Aryan on 2/24/2017.
 */
public class Wall extends Entity {


    public Wall(World world, Grid grid) {
        super(world, grid);
    }

    @Override
    public String getName() {
        return "wall";
    }
}
