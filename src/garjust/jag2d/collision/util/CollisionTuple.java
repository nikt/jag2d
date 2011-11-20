package garjust.jag2d.collision.util;

import garjust.jag2d.collision.Collidable;

/**
 *
 * @author Justin Garbutt
 */
public class CollisionTuple {
    
    private final Collidable a;
    private final Collidable b;
    
    public CollisionTuple(final Collidable a, final Collidable b) {
        this.a = a;
        this.b = b;
    }
    
    public Collidable a() {
        return a;
    }
    
    public Collidable b() {
        return b;
    }
}
