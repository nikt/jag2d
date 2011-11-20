package garjust.jag2d.collision;

import garjust.jag2d.geometry.Circle;
import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.ReadOnlyPoint;
import garjust.jag2d.geometry.ReadOnlyPolygon;
import garjust.jag2d.geometry.ReadOnlyRectangle;
import garjust.jag2d.geometry.ReadOnlyVector;

import java.awt.Color;

/**
 *
 * @author Justin Garbutt
 */
public class BoundingCircle implements BoundingGeometry {

    private final Point position;
    private final int radius;

    public BoundingCircle(final ReadOnlyPoint position, final int radius) {
        this.position = new Point(position);
        this.radius = radius;
    }

    public BoundingCircle(final Circle circle) {
        this.position = circle.center();
        this.radius = circle.radius();

    }

    // TODO rounding makes small circles error prone
    public BoundingCircle(final ReadOnlyRectangle rectangle) {
        this.position = new Point(rectangle.x() + rectangle.w() / 2, rectangle.y() + rectangle.h() / 2);
        this.radius = (int) Math.sqrt(rectangle.w() + rectangle.h());
    }

    // TODO rounding makes small circles error prone
    public BoundingCircle(final ReadOnlyPolygon polygon) {
        this.position = polygon.centre();
        float max = 0;
        for (ReadOnlyPoint vertex : polygon.vertices()) {
            final ReadOnlyVector vector = Point.pointToPointVector(position, vertex);
            final float length = vector.length();
            if (length > max) {
                max = length;
            }
        }
        this.radius = (int) max;
    }

    /**
     * Draws the bounding box [TESTING PURPOSES]
     * @param graphics Graphics context for drawing
     */
    public void draw(final java.awt.Graphics2D graphics) {
        final Color color_save = graphics.getColor();
        graphics.setColor(Color.GREEN);
        graphics.drawOval(position.getSnappedX(), position.getSnappedY(), radius, radius);
        graphics.setColor(color_save);
    }

    /**
     * Builds a rectangle from the bounding box
     * @return A rectangle equal to this bounding box
     */
    public Circle toCircle() {
        return new Circle(position, radius);
    }

    /**
     * Builds a string representing an Axis-Aligned Bounding Circle in the form<br />
     * [AABB: $UL $LR]
     * 
     * @return String representation of a BoundingCircle
     */
    @Override
    public String toString() {
        return "[BC: pos=" + position.toString() + " radius=" + radius + "]";
    }
}
