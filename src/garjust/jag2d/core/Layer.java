package garjust.jag2d.core;

import java.util.ArrayList;

/**
 *
 * @author t_garbj
 */
public class Layer<E extends Entity> extends ArrayList<E> {

    public Layer() {
        super();
    }

    public Layer(final int size) {
        super(size);
    }

    public void draw(java.awt.Graphics2D graphics) {
        for(Entity entity: this) {
            entity.draw(graphics);
        }
    }

    public void update(final float delta) {
        for(Entity entity: this) {
            entity.update(delta);
        }
    }
}
