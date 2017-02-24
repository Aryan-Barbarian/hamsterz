package location;

/**
 * Created by aryan on 6/17/2016.
 */
public abstract class GridLocation {
    @Override
    public boolean equals(Object obj) {
        // TODO: maybe just have the children override it and use direct values
        return this.hashCode() == obj.hashCode();
    }

}
