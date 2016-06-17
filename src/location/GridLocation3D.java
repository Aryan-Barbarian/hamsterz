package location;

/**
 * Created by aryan on 6/17/2016.
 */
public class GridLocation3D extends GridLocation {
    public int x, y, z;

    @Override
    public int hashCode() {
        int result = x ^ (x >>> 16);
        result = 15 * result + (y ^ (y >>> 16));
        result = 15 * result + (z ^ (z >>> 16));
        return result;
    }
}
