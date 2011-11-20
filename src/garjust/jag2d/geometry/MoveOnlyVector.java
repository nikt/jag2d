package garjust.jag2d.geometry;

/**
 *
 * @author jagarbut
 */
public interface MoveOnlyVector {

    public Vector rotate(final float theta);

    public Vector scale(final float scalar);

    public Vector translate(final float x, final float y);
    
}
