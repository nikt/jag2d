package garjust.jag2d.collision.spatialpartition;

import garjust.jag2d.collision.Collidable;

/**
 *
 * @author jagarbut
 */
public interface Quadrant {
    
    public boolean belongs(final Collidable collidable);

    public boolean contains(final Collidable collidable);
}
