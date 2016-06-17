import location.Grid;
import location.GridLocation2D;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aryan on 6/17/2016.
 */
public class World {

    private Grid<GridLocation2D> grid;
    private List<Actor> allMembers;
    private List<Actor> actors; // Just those we expect moves from
    // private List<Action> actions; // actions[i] will be actors[i]'s action

    public World(Grid grid) {
        this.grid = grid;
        this.allMembers = new ArrayList<Actor>();
        this.actors = new ArrayList<Actor>();
        // this.actions = new ArrayList<Action>();
    }

    public void turn() {
        // TODO: Implement
        for (Actor actor : this.actors) {
            Action action = actor.getAction(this); // TODO: 6/17/2016 maybe pass in a more abstracted "World state"
            handleAction(actor, action);
        }
    }

    private void handleAction(Actor actor, Action action) {
        // TODO: Possibly send to its own class one day
        GridLocation2D location = grid.locationOf(actor);
        switch (action) {
            case MOVE_FORWARD:
                //
                break;
            case MOVE_BACK:
                //
                break;
            case TURN_LEFT:
                //
                break;
            case TURN_RIGHT:
                //
                break;
            case EAT:
                //
                break;
            case DIE:
                //
                break;
            case DO_NOTHING:
                //
                break;
            case DEFEND:
                //
                break;
            default:
                //
                break;
        }

    }

}
