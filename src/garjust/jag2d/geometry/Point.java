package garjust.jag2d.geometry;

import garjust.jag2d.util.FloatMath;
import garjust.jag2d.util.GraphicsConfig;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Justin Garbutt
 */
public final class Point implements Drawable, Geometry, ReadOnlyPoint, WriteOnlyPoint, MoveOnlyPoint {

    public static final ReadOnlyPoint ZERO = new Point(0, 0);
    //
    private float x;
    private float y;

    public Point() {
        this.x = ZERO.x();
        this.y = ZERO.y();
    }

    public Point(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public Point(final ReadOnlyPoint point) {
        x = point.x();
        y = point.y();
    }

    /**
     * The points x coordinate
     * @return x-coordinate
     */
    public float x() {
        return x;
    }

    /**
     * Point x coordinate
     * @return x coordinate
     */
    public float x(final float x) {
        final float old_x = this.x;
        this.x = x;
        return old_x;
    }

    public int getSnappedX() {
        return Math.round(x);
    }

    /**
     * The points y coordinate
     * @return y-coordinate
     */
    public float y() {
        return y;
    }

    /**
     * Point y coordinate
     * @return y coordinate
     */
    public float y(final float y) {
        final float old_y = this.y;
        this.y = y;
        return old_y;
    }

    public int getSnappedY() {
        return Math.round(y);
    }

    public Point set(final float x, final float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Rotates the point about 0
     * @param theta Rotation angle
     * @return This
     */
    public Point rotate(final float theta) {
        final float temp_x = x;
        x = x * FloatMath.cos(theta) - y * FloatMath.sin(theta);
        y = temp_x * FloatMath.sin(theta) + y * FloatMath.cos(theta);
        return this;
    }

    /**
     * Rotates the point about the point center
     * @param theta Rotation angle
     * @param center Rotation point
     * @return This
     */
    public Point rotate(final float theta, final ReadOnlyPoint center) {
        Point centered = new Point(x - center.x(), y - center.y());
        x = (centered.x() * FloatMath.cos(theta) - centered.y() * FloatMath.sin(theta)) + center.x();
        y = (centered.x() * FloatMath.sin(theta) + centered.y() * FloatMath.cos(theta)) + center.y();
        return this;
    }

    public Point scale(final float scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    /**
     * Translates the point by x,y units
     * @param x X units to translate
     * @param y Y units to translate
     * @return This
     */
    public Point translate(final float x, final float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Returns a new point with rounded coordinates
     * @return Rounded point
     */
    public Point snap() {
        return new Point(Math.round(x), Math.round(y));
    }

    public static Vector pointToPointVector(final ReadOnlyPoint point1, final ReadOnlyPoint point2) {
        return new Vector(point2.x() - point1.x(), point2.y() - point1.y());
    }

    /**
     *
     * @param graphics
     */
    public void draw(final Graphics2D graphics) {
        this.draw(graphics, java.awt.Color.RED);
    }

    public void draw(final Graphics2D graphics, final Color colour) {
        final GraphicsConfig graphics_config = new GraphicsConfig(graphics);
        graphics.setColor(colour);
        graphics.setStroke(new BasicStroke(4));
        graphics.drawRect(getSnappedX(), getSnappedY(), 1, 1);
        graphics_config.set(graphics);
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
        final ReadOnlyPoint point = (Point) other;
        if (point.x() == x && point.y() == y) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Float.floatToIntBits(this.x);
        hash = 97 * hash + Float.floatToIntBits(this.y);
        return hash;
    }

    public float[] toArray() {
        final float[] point = {x, y};
        return point;
    }

    public Vector toVector() {
        return new Vector(x, y);
    }

    /**
     * Returns a string representation of the point in the form<br />
     * (x, y)
     * @return 
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
