package actor;

import core.Game;
import core.World;
import location.Direction;
import location.Grid;
import location.GridLocation2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aryan on 6/17/2016.
 */
public class Hamster extends Actor {

    private int food;

    public Hamster(World world, Grid grid) {
        super(world, grid);
        this.food = 0;
    }

    public void act() {
        super.act();
        food -= 1;
    }

    public  int getFood(){
        return food;
    }

    @Override
    public String getName() {
        return "person";
    }

    @Override
    public List<Action> getLegalActions() {
        ArrayList<Action> prev = (ArrayList) super.getLegalActions(); // TODO: Intantiate instead of cast?
        prev.add(Action.MOVE_FORWARD);
        prev.add(Action.MOVE_LEFT);
        prev.add(Action.MOVE_RIGHT);
        prev.add(Action.MOVE_BACK);
        return prev;
    }


}
