import location.Grid;
import location.GridLocation2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by aryan on 6/17/2016.
 */
public class World {

    private Grid<GridLocation2D> grid;
    private List<Actor> allMembers;
    private List<Actor> actors; // Just those we expect moves from

    public World(Grid grid) {
        this.grid = grid;
        this.allMembers = new ArrayList<Actor>();
        this.actors = new ArrayList<Actor>();
    }

    public void addMember(Actor actor, GridLocation2D to, boolean canMove) {
        allMembers.add(actor);
        if (canMove) {
            actors.add(actor);
        }
        grid.addMember(actor, to);
    }

    public void turn() {
        for (Actor actor : this.actors) {
            Action action = actor.getAction(this); // TODO: 6/17/2016 maybe pass in a more abstracted "World state"
            handleAction(actor, action);
        }
    }

    private void handleAction(Actor actor, Action action) {
        // TODO: Possibly send to its own class one day
        GridLocation2D loc = grid.locationOf(actor);
        boolean moved = false;
        int newX = loc.x;
        int newY = loc.y;

        switch (action) {
            case MOVE_FORWARD:
                newX = loc.x;
                newY = loc.y + 1;
                moved = true;
                break;
            case MOVE_BACK:
                newX = loc.x;
                newY = loc.y - 1;
                moved = true;
                break;
            case MOVE_LEFT:
                newX = loc.x - 1;
                newY = loc.y;
                moved = true;
                break;
            case MOVE_RIGHT:
                newX = loc.x + 1;
                newY = loc.y;
                moved = true;
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

        if (moved) {
            GridLocation2D newLoc = GridLocation2D.getLocation(newX, newY);
            grid.move(actor, loc, newLoc);
        }

    }

    public Map<Actor, GridLocation2D> getDisplayInfoByMember() {
        Map<Actor, GridLocation2D> ans = new TreeMap<Actor, GridLocation2D>();
        for (Actor member : allMembers) {
            GridLocation2D loc = grid.locationOf(member);
            ans.put(member, loc);
        }
        return ans;
    }

    public Map<GridLocation2D, Actor> getDisplayInfoByLocation() {
        Map<GridLocation2D, Actor> ans = new TreeMap<GridLocation2D, Actor>();
        for (Actor member : allMembers) {
            GridLocation2D loc = grid.locationOf(member);
            ans.put(loc, member);
        }
        return ans;
    }

}
