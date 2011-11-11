package jag2d.collision.spatialpartition;

import jag2d.collision.Collidable;

/**
 *
 * @author jagarbut
 */
public interface Quadrant {
    
    public boolean belongs(final Collidable collidable);

    public boolean contains(final Collidable collidable);
}
