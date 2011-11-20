package garjust.jag2d.core;

import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.Vector;

import java.awt.Graphics2D;

/**
 *
 * @author Justin Garbutt
 */
public interface Entity {

    public void draw(Graphics2D graphics);

    public void update(final float delta);

    public boolean collide(final Entity entity);
    
    public Point position();
    
    public Vector velocity();
    
    public float rotation_velocity();
    
}
