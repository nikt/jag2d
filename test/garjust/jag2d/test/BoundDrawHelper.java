package garjust.jag2d.test;

import garjust.jag2d.collision.BoundingBox;
import garjust.jag2d.collision.BoundingCircle;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Justin Garbutt
 */
public final class BoundDrawHelper {

    public static void draw(final Graphics2D graphics, final BoundingBox box) {
        final Color color_save = graphics.getColor();
        graphics.setColor(Color.GREEN);
//        graphics.drawRect((int) box.x(), (int) ul.y(), (int) (lr.x() - ul.x()), (int) (lr.y() - ul.y()));
        graphics.setColor(color_save);
    }

    public static void draw(final Graphics2D graphics, final BoundingCircle circle) {
        final Color color_save = graphics.getColor();
        graphics.setColor(Color.GREEN);
//        graphics.drawOval(position.getSnappedX(), position.getSnappedY(), radius, radius);
        graphics.setColor(color_save);
    }
}
