package garjust.jag2d.geometry;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author jagarbut
 */
public interface ReadOnlyPoint {

    public float x();

    public float y();

    public int getSnappedX();

    public int getSnappedY();

    public void draw(final Graphics2D graphics);
    
    public void draw(final Graphics2D graphics, final Color colour);
    
    @Override
    public String toString();
}
