package location;

import java.util.List;
import java.util.Map;

/**
 * Created by aryan on 6/17/2016.
 */
public class Grid {
    private List<Gridable> members;
    private Map<GridLocation, Gridable> locToMember;
    private Map<Gridable, GridLocation> memberToLoc;

    // TODO: Experimental memoization
    private Map<GridLocation, List<GridLocation>> neighborCache;

    public void addMember(Gridable newMember) {
        // TODO: Implement
    }

    public void addMember(Gridable newMember, GridLocation location) {
        // TODO: Implement
    }

    public void removeMember(Gridable member) {
        // TODO: Implement
    }

    public List<Gridable> getNeighbors(Gridable member) {
        return null; // TODO: implement
    }

    public List<Gridable> cherryPick(List<GridLocation> locations) {
        return null; // TODO: implement
    }

    private List<GridLocation> generateNeighborLocations(GridLocation location) {
        return null; // TODO: implement
    }
}
