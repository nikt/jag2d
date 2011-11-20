package garjust.jag2d.geometry;

import garjust.jag2d.collision.BoundingBox;
import garjust.jag2d.collision.Collidable;
import garjust.jag2d.geometry.util.PointList;

/**
 *
 * @author Justin Garbutt
 */
public class Circle implements Collidable {

    private Point center;
    private int radius;

    public Circle(final Point center, final int radius) {
        this.center = new Point(center);
        this.radius = radius;
    }

    public final Point center() {
        return new Point(center);
    }

    public final int radius() {
        return radius;
    }

    public final Polygon poly() {
        return poly(6);
    }

    public final Polygon poly(final int points) {
        final PointList vertices = new PointList();
        final float point_theta = ((float) Math.PI * 2) / points;
        vertices.add(new Point(center.x(), center.y() + radius));
        for (int i = 1; i < points; i++) {
            vertices.add(new Point(vertices.get(i - 1)).rotate(point_theta, center));
        }
        return new Polygon(vertices);
    }

    public BoundingBox bound() {
        return new BoundingBox(this);
    }

    public void draw(final java.awt.Graphics2D graphics) {
        graphics.drawOval((int) center.x(), (int) center.y(), radius * 2, radius * 2);
    }
}
