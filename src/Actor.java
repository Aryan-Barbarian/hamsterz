/**
 * Created by aryan on 6/17/2016.
 */
public class Actor {

    private Game game;

    public Actor() {
        this(null);
    }

    public Actor(Game game) {
        this.game = game;
    }

    public Action getAction(World world) {
        return Action.IDLE;
    }

    public float utility(World world) {
        return 0;
    }
}
