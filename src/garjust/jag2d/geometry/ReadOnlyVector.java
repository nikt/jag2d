package garjust.jag2d.geometry;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author jagarbut
 */
public interface ReadOnlyVector {

    public float x();

    public float y();

    public int getSnappedX();

    public int getSnappedY();

    public float length();

    public float angle();

    public void draw(final Graphics2D graphics);
    
    public void draw(final Graphics2D graphics, final Color colour);
    
    public void draw(final Graphics2D graphics, final Color colour, final ReadOnlyPoint position);
    
    @Override
    public String toString();
}
