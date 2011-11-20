package garjust.jag2d.geometry;

import garjust.jag2d.collision.BoundingBox;
import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.ReadOnlyRectangle;
import garjust.jag2d.geometry.Rectangle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Justin Garbutt
 */
public class RectangleTest {
    
    @Test
    public void testX() {
        final int expected = 15;
        final int result = new Rectangle(15, 30, 4, 5).x();
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testY() {
        final int expected = 30;
        final int result = new Rectangle(15, 30, 4, 5).y();
        assertEquals(expected, result, 0.0);
    }
    
        @Test
    public void testW() {
        final int expected = 4;
        final int result = new Rectangle(15, 30, 4, 5).w();
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testH() {
        final int expected = 5;
        final int result = new Rectangle(15, 30, 4, 5).h();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testX_int() {
        final Rectangle rectangle = new Rectangle(15, 30, 4, 5);
        final int expected = 15;
        final int result = rectangle.x(50);
        assertEquals(expected, result, 0.001);
        final int expected2 = 50;
        final int result2 = rectangle.x();
        assertEquals(expected2, result2, 0.001);
    }

    @Test
    public void testY_int() {
        final Rectangle rectangle = new Rectangle(15, 30, 4, 4);
        final int expected = 30;
        final int result = rectangle.y(50);
        assertEquals(expected, result, 0.0);
        final int expected2 = 50;
        final int result2 = rectangle.y();
        assertEquals(expected2, result2, 0.001);
    }
    
    @Test
    public void testRotate() {
//        fail("cant rotate");
    }

    @Test
    public void testRotate_point() {
//        fail("cant rotate");
    }

    @Test
    public void testScale() {
        final ReadOnlyRectangle expected = new Rectangle(0, 10, 40, 40);
        final ReadOnlyRectangle result = new Rectangle(0, 10, 4, 4).scale(10);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
        assertEquals(expected.w(), result.w(), 0.001);
        assertEquals(expected.h(), result.h(), 0.001);
    }

    @Test
    public void testTranslate() {
        final ReadOnlyRectangle expected = new Rectangle(3, 11, 20, 20);
        final ReadOnlyRectangle result = new Rectangle(0, 5, 20, 20).translate(3, 6);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
        assertEquals(expected.w(), result.w(), 0.001);
        assertEquals(expected.h(), result.h(), 0.001);
    }
    
    @Test
    public void testBound() {
        final BoundingBox expected = new BoundingBox(new Point(0, 5), new Point(20, 25));
        final BoundingBox result = new Rectangle(0, 5, 20, 20).bound();
        assert(BoundingBox.intersection(expected, result));
    }
    
        @Test
    public void testToString() {
        assertEquals("[Rectangle: (12, 5), w=32, h=33]", new Rectangle(12, 5, 32, 33).toString());
    }
}
