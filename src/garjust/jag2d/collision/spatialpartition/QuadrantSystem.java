package garjust.jag2d.collision.spatialpartition;

import garjust.jag2d.collision.Collidable;
import garjust.jag2d.collision.util.CollidableList;

/**
 *
 * @author Justin Garbutt
 */
public interface QuadrantSystem {
    
    public boolean add(final Collidable collidable);
    
    public boolean remove(final Collidable collidable);
    
    public CollidableList find(final Collidable collidable);
    
    public void update();
}
