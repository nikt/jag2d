package garjust.jag2d.geometry;

/**
 *
 * @author jagarbut
 */
public interface MoveOnlyPolygon {

    public Polygon rotate(final float theta);

    public Polygon rotate(final float theta, final ReadOnlyPoint center);

    public Polygon scale(final float scalar);

    public Polygon translate(final float x, final float y);
}
