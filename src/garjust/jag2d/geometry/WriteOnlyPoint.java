package garjust.jag2d.geometry;

/**
 *
 * @author jagarbut
 */
public interface WriteOnlyPoint {
    
    public float x(final float x);
    
    public float y(final float y); 
    
    public Point set(final float x, final float y);
}
