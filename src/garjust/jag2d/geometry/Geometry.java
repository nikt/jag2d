package garjust.jag2d.geometry;

/**
 *
 * @author Justin Garbutt
 */
public interface Geometry {

    public Geometry rotate(final float theta);

    public Geometry scale(final float scalar);

    public Geometry translate(final float x, final float y);
}
