package garjust.jag2d.geometry;

import garjust.jag2d.collision.BoundingBox;
import garjust.jag2d.collision.Collidable;

/**
 *
 * @author Justin Garbutt
 */
public final class Rectangle implements Collidable, Drawable, Geometry, ReadOnlyRectangle, WriteOnlyRectangle, MoveOnlyRectangle {

    private int x;
    private int y;
    private int w;
    private int h;

    public Rectangle() {
        this.x = 0;
        this.y = 0;
        this.w = 0;
        this.h = 0;
    }

    public Rectangle(final int x, final int y, final int w, final int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Rectangle(final Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.w = rectangle.w;
        this.h = rectangle.h;
    }

    public final int x() {
        return x;
    }

    public final int y() {
        return y;
    }

    public final int w() {
        return w;
    }

    public final int h() {
        return h;
    }

    public final int x(final int x) {
        final int old_x = this.x;
        this.x = x;
        return old_x;
    }

    public final int y(final int y) {
        final int old_y = this.y;
        this.y = y;
        return old_y;
    }

    public final int w(final int w) {
        final int old_w = this.w;
        this.w = w;
        return old_w;
    }

    public final int h(final int h) {
        final int old_h = this.h;
        this.h = h;
        return old_h;
    }

    public Rectangle set(final int x, final int y, final int w, final int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        return this;
    }

    public Rectangle rotate(final float theta) {
        System.err.println("ERROR: Attempted to rotate axis aligned rectangle > " + toString());
        return this;
    }

    public Rectangle rotate(final float theta, final ReadOnlyPoint position) {
        System.err.println("ERROR: Attempted to rotate axis aligned rectangle > " + toString());
        return this;
    }

    public Rectangle scale(final float scalar) {
        this.h *= scalar;
        this.w *= scalar;
        return this;
    }

    public Rectangle translate(final float x, final float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public BoundingBox bound() {
        return new BoundingBox(this);
    }

    public void draw(final java.awt.Graphics2D graphics) {
        graphics.drawRect(x, y, w, h);
    }

    @Override
    public String toString() {
        return "[Rectangle: (" + x + ", " + y + "), w=" + w + ", h=" + h + "]";
    }
}
