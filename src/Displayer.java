import location.GridLocation2D;

import java.util.Map;

/**
 * Created by aryan on 6/17/2016.
 */
public class Displayer {

    private static final char ACTOR_CHAR = '#';
    private static final char EMPTY_CHAR = '.';
    private int width, height, winX, winY;
    private World world;

    public Displayer(World world, int width, int height) {
        this.world = world;
        this.width = width;
        this.height = height;
        this.winX = 0;
        this.winY = 0;
    }

    public void updateDisplay() {
        Map<GridLocation2D, Actor> locToActor = world.getDisplayInfoByLocation();
        StringBuilder builder = new StringBuilder(" # # # # # STATE # # # # # ");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int x = winX + i;
                int y = winY + j;
                char charToAdd = EMPTY_CHAR;
                GridLocation2D key = GridLocation2D.getLocation(x, y);
                if (locToActor.containsKey(key)) {
                    charToAdd = ACTOR_CHAR;
                }
                builder.append(charToAdd);
            }
            builder.append('\n');
        }
        System.out.print(builder.toString());
    }
}
