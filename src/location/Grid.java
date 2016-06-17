package location;

import java.util.List;
import java.util.Map;

/**
 * Created by aryan on 6/17/2016.
 */
// TODO: add <E>
public class Grid<LOC extends GridLocation> {
    private List<Gridable> members;
    private Map<LOC, Gridable> locToMember;
    private Map<Gridable, LOC> memberToLoc;

    public LOC locationOf(Gridable member) {
        return memberToLoc.get(member);
    }

    public void addMember(Gridable newMember, LOC location) {
        this.members.add(newMember);
        locToMember.put(location, newMember);
        memberToLoc.put(newMember, location);
    }

    public void removeMember(Gridable member) {
        LOC location = memberToLoc.get(member);
        members.remove(member);
        locToMember.remove(location);
        memberToLoc.remove(member);
    }

    public void move(LOC from, LOC to) {
        Gridable member = locToMember.get(from);
        move(member, from, to);
    }

    public void move(Gridable member, LOC to) {
        LOC from = memberToLoc.get(member);
        move(member, from, to);
    }

    public void move(Gridable member, LOC from, LOC to) {
        locToMember.remove(from);
        locToMember.put(to, member);
        memberToLoc.replace(member, to);
    }

}
