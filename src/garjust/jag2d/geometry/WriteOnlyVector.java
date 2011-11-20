package garjust.jag2d.geometry;

/**
 *
 * @author jagarbut
 */
public interface WriteOnlyVector {
    
    public float x(final float x);
    
    public float y(final float y); 
    
    public Vector set(final float x, final float y);
}
