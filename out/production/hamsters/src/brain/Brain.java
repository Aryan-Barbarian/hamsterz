package brain;

import actor.Action;
import actor.Entity;

import java.util.List;

/**
 * Created by Aryan on 2/24/2017.
 */
public class Brain {


    private Entity entity;
    public Brain(Entity entity) {
        this.entity = entity;
    }

    public Action getAction(List<Action> legalMoves) {
        if (legalMoves.size() == 0) {
            System.err.println("Warning, entity left with no available moves");
            return Action.DO_NOTHING;
        }
        return legalMoves.get(0); // TODO: Do the first thing
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
