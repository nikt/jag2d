package jag2d.collision.util;

import jag2d.collision.Collidable;
import java.util.ArrayList;

/**
 *
 * @author Justin Garbutt
 */
public class CollidableList extends ArrayList<Collidable> {
        
    public CollidableList() {
        super();
    }

    public CollidableList(int size) {
        super(size);
    }
}
