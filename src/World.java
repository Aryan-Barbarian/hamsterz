import location.Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aryan on 6/17/2016.
 */
public class World {

    private Grid grid;
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
    }

}
