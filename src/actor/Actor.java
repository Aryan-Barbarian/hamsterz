package actor;

import brain.Brain;
import core.World;
import location.Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aryan on 6/17/2016.
 */
public class  Actor extends Entity {

    private Brain brain;

    public Actor(World world, Grid grid) {
        super(world, grid);
        this.brain = new Brain(this);
    }

    public void act() {
//        TODO: Move actor code into other classes for better modularity.
//        Action action = getAction(); // TODO: Get rid of this for performance reasons?
        // Create Gamestate TODO: this will be more official later
        List<Action> legalMoves = this.getLegalActions();
        Action chosenMove = this.brain.getAction(legalMoves);
        // TODO: Log result?
        this.handleAction(chosenMove);
    }

    public List<Action> getLegalActions() {
        List<Action> ans = new ArrayList<Action>();
        // TODO: make this more effecient one day
        ans.add(Action.DO_NOTHING);
        ans.add(Action.DIE);

        return ans;
    }



    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        this.brain = brain;
    }
}
