package garjust.jag2d.geometry;

/**
 *
 * @author jagarbut
 */
public interface MoveOnlyRectangle {

    public Rectangle rotate(final float theta);

    public Rectangle rotate(final float theta, final ReadOnlyPoint center);

    public Rectangle scale(final float scalar);

    public Rectangle translate(final float x, final float y);
}
