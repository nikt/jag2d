package garjust.jag2d.collision;

import garjust.jag2d.geometry.Circle;
import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.Polygon;
import garjust.jag2d.geometry.Rectangle;

import java.awt.Color;

/**
 *
 * @author JAG-LAPTOP
 */
public final class BoundingBox implements BoundingGeometry {

    private final Point ul, lr;

    public BoundingBox(final Point ul, final Point lr) {
        this.ul = new Point(ul);
        this.lr = new Point(lr);
    }

    public BoundingBox(final Circle circle) {
        final Point center = circle.center();
        final int radius = circle.radius();
        this.ul = new Point(center.translate(-1 * radius, -1 * radius));
        this.lr = new Point(center.translate(radius, radius));
    }

    public BoundingBox(final Rectangle rectangle) {
        this.ul = new Point(rectangle.x(), rectangle.y());
        this.lr = new Point(rectangle.x() + rectangle.w(), rectangle.y() + rectangle.h());
    }

    public BoundingBox(final Polygon polygon) {
        float min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE;
        float max_x = Integer.MIN_VALUE, max_y = Integer.MIN_VALUE;
        for (Point vertex : polygon.vertices()) {
            if (vertex.x() < min_x) {
                min_x = vertex.x();
            }
            if (vertex.x() > max_x) {
                max_x = vertex.x();
            }
            if (vertex.y() < min_y) {
                min_y = vertex.y();
            }
            if (vertex.y() > max_y) {
                max_y = vertex.y();
            }
        }
        this.ul = new Point(min_x, min_y);
        this.lr = new Point(max_x, max_y);
    }

    /**
     * Draws the bounding box [TESTING PURPOSES]
     * @param graphics Graphics context for drawing
     */
    public void draw(final java.awt.Graphics2D graphics) {
        final Color color_save = graphics.getColor();
        graphics.setColor(Color.GREEN);
        graphics.drawRect((int) ul.x(), (int) ul.y(), (int) (lr.x() - ul.x()), (int) (lr.y() - ul.y()));
        graphics.setColor(color_save);
    }

    /**
     * Builds a rectangle from the bounding box
     * @return A rectangle equal to this bounding box
     */
    public Rectangle toRectangle() {
        return new Rectangle((int) ul.x(), (int) ul.y(), (int) (lr.x() - ul.x()), (int) (lr.y() - ul.y()));
    }

    /**
     * Builds a string representing an Axis-Aligned Bounding Box in the form<br />
     * [AABB: $UL $LR]
     * 
     * @return String representation of a BoundingBox
     */
    @Override
    public String toString() {
        return "[AABB: UL=" + ul.toString() + " LR=" + lr.toString() + "]";
    }

    /**
     * Tests for intersection between two bounding boxes
     * @param box1 First bounding box
     * @param box2 Second bounding box
     * @return True if the bounding boxes intersect
     */
    public static boolean intersection(final BoundingBox box1, final BoundingBox box2) {
        if (box1.ul.x() > box2.lr.x() || box2.ul.x() > box1.lr.x() || box1.ul.y() > box2.lr.y() || box2.ul.y() > box1.lr.y()) {
            return false;
        }
        return true;
    }
}
