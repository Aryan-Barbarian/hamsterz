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

    public void addMember(Gridable newMember, GridLocation location) {
        this.members.add(newMember);
        locToMember.put(location, newMember);
        memberToLoc.put(newMember, location);
    }

    public void removeMember(Gridable member) {
        GridLocation location = memberToLoc.get(member);
        members.remove(member);
        locToMember.remove(location);
        memberToLoc.remove(member);
    }

    public void move(GridLocation from, GridLocation to) {
        Gridable member = locToMember.get(from);
        move(member, from, to);
    }

    public void move(Gridable member, GridLocation to) {
        GridLocation from = memberToLoc.get(member);
        move(member, from, to);
    }

    private void move(Gridable member, GridLocation from, GridLocation to) {
        locToMember.remove(from);
        locToMember.put(to, member);
        memberToLoc.replace(member, to);
    }
}
