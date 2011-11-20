package garjust.jag2d.collision.spatialpartition;

import garjust.jag2d.collision.BoundingBox;
import garjust.jag2d.collision.Collidable;
import garjust.jag2d.collision.util.CollidableList;
import garjust.jag2d.geometry.Point;

/**
 *
 * @author Justin Garbutt
 */
public class BoundingBoxQuadrant implements Quadrant, Collidable {

    private final CollidableList collidables;
    private final BoundingBox bounds;

    public BoundingBoxQuadrant(final Point ul, final Point br) {
        this.collidables = new CollidableList();
        this.bounds = new BoundingBox(ul, br);
    }

    public boolean belongs(final Collidable collidable) {
        if (BoundingBox.intersection(bounds, collidable.bound())) {
            if (!collidables.contains(collidable)) {
                collidables.add(collidable);
            }
            return true;
        }
        if (collidables.contains(collidable)) {
            collidables.remove(collidable);
        }
        return false;
    }

    public boolean contains(final Collidable collidable) {
        return collidables.contains(collidable);
    }
    
    public boolean remove(final Collidable collidable) {
        collidables.remove(collidable);
        return true;
    }
    
    public CollidableList retrieve(final Collidable collidable) {
        final CollidableList list = new CollidableList();
        if(collidables.contains(collidable)) {
            list.addAll(collidables);
            list.remove(collidable);
        }
        return list;
    }

    @Override
    public BoundingBox bound() {
        return bounds;
    }
}
