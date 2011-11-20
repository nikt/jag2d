package garjust.jag2d.geometry;

import garjust.jag2d.collision.BoundingBox;
import garjust.jag2d.collision.Collidable;
import garjust.jag2d.geometry.util.PointList;
import garjust.jag2d.util.Sort;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Justin Garbutt
 */
public class Polygon implements Collidable, Drawable, Geometry, ReadOnlyPolygon, WriteOnlyPolygon, MoveOnlyPolygon {

    private PointList vertices;
    private Point centre;
    private Polygon hull;

    public Polygon() {
        this.vertices = new PointList();
        this.centre = null;
        this.hull = null;
    }

    public Polygon(final PointList vertices) {
        this.vertices = new PointList(vertices);
        this.centre = null;
        this.hull = null;
    }

    /**
     * COPY CONSTRUCTOR
     * @param polygon 
     */
    public Polygon(final ReadOnlyPolygon polygon) {
        this.vertices = new PointList(polygon.vertices());
        this.centre = null;
        this.hull = null;
    }

    public Polygon(final ReadOnlyRectangle rectangle) {
        this.vertices = new PointList(4);
        vertices.add(new Point(rectangle.x(), rectangle.y()));
        vertices.add(new Point(rectangle.x(), rectangle.y() + rectangle.h()));
        vertices.add(new Point(rectangle.x() + rectangle.w(), rectangle.y()));
        vertices.add(new Point(rectangle.x() + rectangle.w(), rectangle.y() + rectangle.h()));
        this.centre = null;
        this.hull = null;
    }

    public final PointList vertices() {
        return new PointList(vertices);
    }

    public final Point centre() {
        if (centre == null) {
            float x_total = 0;
            float y_total = 0;
            for (Point vertex : this.vertices()) {
                x_total += vertex.x();
                y_total += vertex.y();
            }
            x_total /= this.vertices().size();
            y_total /= this.vertices().size();
            centre = new Point(x_total, y_total);
        }
        return new Point(centre);
    }

    public final Polygon hull() {
        if (hull == null) {
            Point lowest_y = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
            for (Point vertex : vertices) {
                if (vertex.y() < lowest_y.y()) {
                    lowest_y = vertex;
                } else if (vertex.y() == lowest_y.y()) {
                    if (vertex.x() < lowest_y.x()) {
                        lowest_y = vertex;
                    }
                }
            }
            Point[] points = new Point[vertices.size()];
            points = vertices.toArray(points);
            float[] sortee = new float[vertices.size()];
            for (int i = 0; i < sortee.length; i++) {
                if (points[i] == lowest_y) {
                    sortee[i] = 0;
                } else {
                    sortee[i] = Point.pointToPointVector(points[i], lowest_y).angle();
                }
            }
            Sort.bubble(sortee, points);
            PointList the_hull = new PointList(points.length);
            the_hull.add(points[0]);
            the_hull.add(points[1]);
            int stack = 2;
            for (int i = 2; i < points.length; i++) {
                while (ccw(the_hull.get(stack - 2), the_hull.get(stack - 1), points[i]) > 0) { // WHILE RIGHT TURN
                    the_hull.remove(stack - 1);
                    stack--;
                    if (stack == 1) {
                        break;
                    }
                }
                the_hull.add(points[i]);
                stack++;
            }
            hull = new Polygon(the_hull);
        }
        return new Polygon(hull);
    }

    public final PointList vertices(final PointList new_vertices) {
        final PointList old_vertices = vertices;
        vertices = new PointList(new_vertices);
        return old_vertices;
    }

    public final Point resetCentre() {
        final Point old_centre = centre;
        centre = null;
        return old_centre;
    }

    public final Polygon resetHull() {
        final Polygon old_hull = hull;
        hull = null;
        return old_hull;
    }

    /**
     * 
     * @param theta
     * @return 
     */
    public Polygon rotate(final float theta) {
        for (MoveOnlyPoint vertex : vertices) {
            vertex.rotate(theta);
        }
        if (hull != null) {
            hull.rotate(theta);
        }
        if (centre != null) {
            centre.rotate(theta);
        }
        return this;
    }

    /**
     * 
     * @param theta
     * @return 
     */
    public Polygon rotate(final float theta, final ReadOnlyPoint position) {
        for (MoveOnlyPoint vertex : vertices) {
            vertex.rotate(theta, position);
        }
        if (hull != null) {
            hull.rotate(theta, position);
        }
        if (centre != null) {
            centre.rotate(theta, position);
        }
        return this;
    }

    public Polygon scale(final float scalar) {
        centre();
        for (MoveOnlyPoint vertex : vertices) {
            vertex.translate(-1 * centre.x(), -1 * centre.y());
            vertex.scale(scalar);
            vertex.translate(centre.x(), centre.y());
        }
        resetCentre();
        resetHull();
        return this;
    }

    public Polygon translate(final float x, final float y) {
        for (MoveOnlyPoint vertex : vertices) {
            vertex.translate(x, y);
        }
        if (hull != null) {
            hull.translate(x, y);
        }
        if (centre != null) {
            centre.translate(x, y);
        }
        return this;
    }

    public void draw(final Graphics2D graphics) {
        draw(graphics, false);
    }

    public void draw(final Graphics2D graphics, final boolean debug) {
        if (debug) {
            centre();
            hull();
            Color color_save = graphics.getColor();
            graphics.setColor(Color.YELLOW);
            final int[][] coordinate_matrix = hull().vertices().getCoordinateMatrix();
            graphics.drawPolygon(coordinate_matrix[0], coordinate_matrix[1], hull().vertices().size());
            centre.draw(graphics, Color.YELLOW);
            graphics.setColor(color_save);
        }
        final int[][] coordinate_matrix = vertices.getCoordinateMatrix();
        graphics.drawPolygon(coordinate_matrix[0], coordinate_matrix[1], vertices.size());       
    }

    /**
     * 
     * @return 
     */
    public BoundingBox bound() {
        return new BoundingBox(this);
    }

    public Polygon deform(final Point deform_origin) {
        return deform(deform_origin, 1, 1);
    }

    public Polygon deform(final Point deform_origin, final float radial_variance, final float tangential_variance) {
        float radial_magnitude = 0;
        for (int i = 0; i < vertices.size(); i++) {
            radial_magnitude = (float) Math.random() * radial_variance + 1;
            deformPoint(vertices.get(i), deform_origin, radial_magnitude);
            deformPoint(vertices.get(i == 0 ? vertices.size() - 1 : i - 1), deform_origin, radial_magnitude / 2);
            deformPoint(vertices.get((i + 1) % vertices.size()), deform_origin, radial_magnitude / 2);
        }
        return this;
    }

    private void deformPoint(final Point point, final Point deform_origin, final float radial_magnitude) {
        point.translate(-1 * deform_origin.x(), -1 * deform_origin.y());
        point.scale(radial_magnitude);
        point.translate(deform_origin.x(), deform_origin.y());
    }

    private static float ccw(final Point p1, final Point p2, final Point p3) {
        return (p2.x() - p1.x()) * (p3.y() - p1.y()) - (p2.y() - p1.y()) * (p3.x() - p1.x());
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        } else if (other == this) {
            return true;
        } else if (this.getClass() != other.getClass()) {
            return false;
        }
        final ReadOnlyPolygon polygon = (Polygon) other;
        if (vertices.equals(polygon.vertices())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.vertices != null ? this.vertices.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        String polygon = "[Polygon:";
        for (ReadOnlyPoint vertex : vertices) {
            polygon += " " + vertex.toString();
        }
        return polygon + "]";
    }
}
