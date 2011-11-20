package garjust.jag2d.geometry;

/**
 *
 * @author jagarbut
 */
public interface MoveOnlyPoint {

    public Point rotate(final float theta);

    public Point rotate(final float theta, final ReadOnlyPoint center);

    public Point scale(final float scalar);

    public Point translate(final float x, final float y);
}
