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
public final class Vector implements Drawable, Geometry, ReadOnlyVector, WriteOnlyVector, MoveOnlyVector {

    public static final ReadOnlyVector ZERO = new Vector(0, 0);
    public static final ReadOnlyVector X_UNIT_VECTOR = new Vector(1, 0);
    public static final ReadOnlyVector Y_UNIT_VECTOR = new Vector(0, 1);
    public static final ReadOnlyVector DIAGONAL_VECTOR = new Vector(1, 1).unit();
    //
    private float x;
    private float y;

    public Vector() {
        this.x = ZERO.x();
        this.y = ZERO.y();
    }

    public Vector(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public Vector(final ReadOnlyVector vector) {
        x = vector.x();
        y = vector.y();
    }

    /**
     * Vector x component
     * @return x coordinate
     */
    public float x() {
        return x;
    }

    /**
     * Vector y component
     * @return y coordinate
     */
    public float y() {
        return y;
    }

    public float x(final float x) {
        final float old_x = this.x;
        this.x = x;
        return old_x;
    }

    public float y(final float y) {
        final float old_y = this.y;
        this.y = y;
        return old_y;
    }

    public int getSnappedX() {
        return Math.round(x);
    }

    public int getSnappedY() {
        return Math.round(y);
    }

    public Vector set(final float x, final float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Calculates the length of the vector
     * @return Length of the vector
     */
    public float length() {
        return FloatMath.sqrt(x * x + y * y);
    }

    /**
     * Calculates the angle the vector makes with the x-axis
     * @return Angle of the vector
     */
    public float angle() {
        return length() == 0 ? 0 : FloatMath.acos(x / length());
    }

    /**
     *
     * @param theta
     * @return
     */
    public Vector rotate(final float theta) {
        final float temp_x = x;
        x = x * FloatMath.cos(theta) - y * FloatMath.sin(theta);
        y = temp_x * FloatMath.sin(theta) + y * FloatMath.cos(theta);
        return this;
    }

    public Vector scale(final float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    /**
     * Translates the vector by x,y units
     *
     * <p>DESTRUCTIVE</p>
     *
     * @param x
     * @param y
     * @return This vector
     */
    public Vector translate(final float x, final float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Returns a new vector with the given magnitude with the same direction
     *
     * @param new_length The new magnitude
     * @return A new vector
     */
    public Vector length(final float new_length) {
        final ReadOnlyVector unit = unit();
        return new Vector(unit.x() * new_length, unit.y() * new_length);
    }

    /**
     * Creates a new vector with this vectors  x and y coordinates rounded
     *
     * @return this
     */
    public Vector snap() {
        return new Vector(Math.round(x), Math.round(y));
    }

    /**
     *
     * @return this
     */
    public Vector negate() {
        return new Vector(-x, -y);
    }

    /**
     * Returns the unit vector corresponding to this vector
     *
     * @return A unit vector
     */
    public Vector unit() {
        final float magnitude = length();
        return new Vector(x / magnitude, y / magnitude);
    }

    public Vector normal() {
        return new Vector(-y, x);
    }

    public static float angle(Vector vector1, Vector vector2) {
        return FloatMath.acos(dot(vector1, vector2) / (vector1.length() * vector2.length())) * 180 / FloatMath.PI;
    }

    public static float dot(final ReadOnlyVector vector1, final ReadOnlyVector vector2) {
        return vector1.x() * vector2.x() + vector1.y() * vector2.y();
    }

    public static Vector add(final ReadOnlyVector vector1, final ReadOnlyVector vector2) {
        return new Vector(vector1.x() + vector2.x(), vector1.y() + vector2.y());
    }

    public static Vector subtract(final ReadOnlyVector vector1, final ReadOnlyVector vector2) {
        return add(vector1, new Vector(vector2).negate());
    }

    public static Vector pointToPointVector(final ReadOnlyVector vector1, final ReadOnlyVector vector2) {
        return subtract(vector2, vector1);
    }

    public void draw(final Graphics2D graphics) {
        draw(graphics, Color.RED, Point.ZERO);
    }

    public void draw(final Graphics2D graphics, final Color colour) {
        draw(graphics, colour, Point.ZERO);
    }

    public void draw(final Graphics2D graphics, final Color colour, final ReadOnlyPoint location) {
        final GraphicsConfig graphics_config = new GraphicsConfig(graphics);
        graphics.setColor(java.awt.Color.WHITE);
        graphics.setStroke(new BasicStroke(1));
        graphics.drawLine(location.getSnappedX(), location.getSnappedY(), location.getSnappedX() + getSnappedX(), location.getSnappedY() + getSnappedY());
        graphics.setStroke(new BasicStroke(2));
        graphics.drawRect(location.getSnappedX(), location.getSnappedY(), 1, 1);
        graphics.setColor(colour);
        graphics.setStroke(new BasicStroke(4));
        graphics.drawRect(location.getSnappedX() + getSnappedX(), location.getSnappedY() + getSnappedY(), 1, 1);
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
        final ReadOnlyVector vector = (Vector) other;
        if (vector.x() == x && vector.y() == y) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Float.floatToIntBits(this.x);
        hash = 23 * hash + Float.floatToIntBits(this.y);
        return hash;
    }

    public float[] toArray() {
        final float[] vector = {x, y};
        return vector;
    }

    public Point toPoint() {
        return new Point(x, y);
    }

    /**
     *
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
