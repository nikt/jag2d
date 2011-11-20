package garjust.jag2d.geometry;

import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.ReadOnlyPoint;
import garjust.jag2d.geometry.ReadOnlyVector;
import garjust.jag2d.geometry.Vector;
import garjust.jag2d.util.FloatMath;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jagarbut
 */
public class PointTest {

    public PointTest() {
    }
    
    @Test
    public void testX() {
        final float expected = 15;
        final float result = new Point(15, 30).x();
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testY() {
        final float expected = 30;
        final float result = new Point(15, 30).y();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testX_float() {
        final Point point = new Point(15, 30);
        final float expected = 15;
        final float result = point.x(50);
        assertEquals(expected, result, 0.001);
        final float expected2 = 50;
        final float result2 = point.x();
        assertEquals(expected2, result2, 0.001);
    }

    @Test
    public void testY_float() {
        final Point point = new Point(15, 30);
        final float expected = 30;
        final float result = point.y(50);
        assertEquals(expected, result, 0.0);
        final float expected2 = 50;
        final float result2 = point.y();
        assertEquals(expected2, result2, 0.001);
    }

    @Test
    public void testGetSnappedX() {
        final int expected = 15;
        final int result = new Point(15.3f, 30.5f).getSnappedX();
        assertEquals(expected, result);
    }

    @Test
    public void testGetSnappedY() {
        final int expected = 31;
        final int result = new Vector(15.3f, 30.5f).getSnappedY();
        assertEquals(expected, result);
    }

    @Test
    public void testSet() {
        final ReadOnlyPoint expected = new Point(5, 6);
        final ReadOnlyPoint result = new Point(3, 4).set(5, 6);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testRotate() {
        final ReadOnlyPoint expected = new Point(0, 5);
        final ReadOnlyPoint result = new Point(5, 0).rotate(FloatMath.PI / 2);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testRotate_point() {
        final ReadOnlyPoint expected = new Point(0, 5);
        final ReadOnlyPoint result = new Point(5, 0).rotate(FloatMath.PI / 2, Point.ZERO);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testScale() {
        final ReadOnlyPoint expected = new Point(0, 10);
        final ReadOnlyPoint result = new Point(0, 1).scale(10);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testTranslate() {
        final ReadOnlyPoint expected = new Point(3, 8);
        final ReadOnlyPoint result = new Point(0, 5).translate(3, 3);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testSnap() {
        final ReadOnlyPoint expected = new Point(4, 8);
        final ReadOnlyPoint result = new Point(3.9f, 8.4f).snap();
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testPointToPointVector_Point_Point() {
        Vector vector = Point.pointToPointVector(new Point(4, 5), new Point(7, 2));
        assertEquals(3, vector.x(), 0.001);
        assertEquals(-3, vector.y(), 0.001);
    }
    
        @Test
    public void testEquals() {
        ReadOnlyPoint point = new Point(7, 2);
        ReadOnlyPoint point_copy = point;
        ReadOnlyPoint point_same = new Point(7, 2);
        ReadOnlyPoint point_diff = new Point(7.2f, 3);
        assert(point.equals(point_copy));
        assert(point.equals(point_same));
        assert(!point.equals(point_diff));
    }

    @Test
    public void testToArray() {
        final float[] array = new Point(1, 2).toArray();
        assertEquals(1, array[0], 0.001);
        assertEquals(2, array[1], 0.001);
    }

    @Test
    public void testToVector() {
        final ReadOnlyVector vector = new Point(1, 2).toVector();
        assertEquals(1, vector.x(), 0.001);
        assertEquals(2, vector.y(), 0.001);
    }

    @Test
    public void testToString() {
        assertEquals("(1.0, 2.0)", new Point(1, 2).toString());
    }
}
