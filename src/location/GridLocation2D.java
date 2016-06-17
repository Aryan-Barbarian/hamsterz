package location;

import java.util.HashMap;

/**
 * Created by aryan on 6/17/2016.
 */
public class GridLocation2D extends GridLocation {
    private static HashMap<int[], GridLocation2D> locationHash;
    public int x, y;

    public GridLocation2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static GridLocation2D getLocation(int x, int y) {
        int[] key = {x, y};
        if (!locationHash.containsKey(key)) {
            locationHash.put(key, new GridLocation2D(x, y));
        }
        return locationHash.get(key);
    }

    @Override
    public int hashCode() {
        int z = 0;
        int result = x ^ (x >>> 16);
        result = 15 * result + (y ^ (y >>> 16));
        result = 15 * result + (z ^ (z >>> 16));
        return result;
    }
}
