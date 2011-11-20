package garjust.jag2d.geometry;

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
public class VectorTest {

    public VectorTest() {
    }

    @Test
    public void _testConstants() {
        assertEquals(0, Vector.ZERO.length(), 0);
        assertEquals(1, Vector.X_UNIT_VECTOR.length(), 0);
        assertEquals(1, Vector.Y_UNIT_VECTOR.length(), 0);
        assertEquals(1, Vector.DIAGONAL_VECTOR.length(), 0.001);
        assertEquals(0, Vector.ZERO.angle(), 0);
        assertEquals(0, Vector.X_UNIT_VECTOR.angle(), 0);
        assertEquals(FloatMath.PI / 2, Vector.Y_UNIT_VECTOR.angle(), 0.001);
        assertEquals(FloatMath.PI / 4, Vector.DIAGONAL_VECTOR.angle(), 0.001);
    }

    @Test
    public void testX() {
        final float expected = 15;
        final float result = new Vector(15, 30).x();
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testY() {
        final float expected = 30;
        final float result = new Vector(15, 30).y();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testX_float() {
        final Vector vector = new Vector(15, 30);
        final float expected = 15;
        final float result = vector.x(50);
        assertEquals(expected, result, 0.001);
        final float expected2 = 50;
        final float result2 = vector.x();
        assertEquals(expected2, result2, 0.001);
    }

    @Test
    public void testY_float() {
        final Vector vector = new Vector(15, 30);
        final float expected = 30;
        final float result = vector.y(50);
        assertEquals(expected, result, 0.0);
        final float expected2 = 50;
        final float result2 = vector.y();
        assertEquals(expected2, result2, 0.001);
    }

    @Test
    public void testGetSnappedX() {
        final int expected = 15;
        final int result = new Vector(15.3f, 30.5f).getSnappedX();
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
        final ReadOnlyVector expected = new Vector(5, 6);
        final ReadOnlyVector result = new Vector(3, 4).set(5, 6);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testLength() {
        assertEquals(Math.sqrt(50), new Vector(5, 5).length(), 0.001);
        assertEquals(Math.sqrt(5), new Vector(1, 2).length(), 0.001);
    }

    @Test
    public void testAngle() {
        assertEquals(Math.PI / 4, new Vector(5, 5).angle(), 0.001);
        assertEquals(0.38051, new Vector(10, 4).angle(), 0.001);
    }

    @Test
    public void testRotate() {
        final ReadOnlyVector expected = new Vector(0, 5);
        final ReadOnlyVector result = new Vector(5, 0).rotate(FloatMath.PI / 2);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testScale() {
        final ReadOnlyVector expected = new Vector(0, 10);
        final ReadOnlyVector result = new Vector(0, 1).scale(10);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testTranslate() {
        final ReadOnlyVector expected = new Vector(3, 8);
        final ReadOnlyVector result = new Vector(0, 5).translate(3, 3);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testLength_float() {
        final ReadOnlyVector expected = new Vector(5, 0);
        final ReadOnlyVector result = new Vector(1, 0).length(5);
        assertEquals(5, result.length(), 0.001);
        assertEquals(expected.angle(), result.angle(), 0.001);
        final ReadOnlyVector expected2 = new Vector(35, 26);
        final ReadOnlyVector result2 = new Vector(35, 26).length(5);
        assertEquals(5, result2.length(), 0.001);
        assertEquals(expected2.angle(), result2.angle(), 0.001);
    }

    @Test
    public void testSnap() {
        final ReadOnlyVector expected = new Vector(4, 8);
        final ReadOnlyVector result = new Vector(3.9f, 8.4f).snap();
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testNegate() {
        final ReadOnlyVector expected = new Vector(-15, 3);
        final ReadOnlyVector result = new Vector(15, -3).negate();
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testUnit() {
        final ReadOnlyVector expected = new Vector(1, 0);
        final ReadOnlyVector result = new Vector(55, 0).unit();
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testNormal() {
        final ReadOnlyVector expected = new Vector(-3, 8);
        final ReadOnlyVector result = new Vector(8, 3).normal();
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
    }

    @Test
    public void testAngle_Vector_Vector() {
        final float result = Vector.angle(new Vector(8, 7), new Vector(4, 4));
        final float expected = 3.814074835f;
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testDot() {
        final float result = Vector.dot(new Vector(8, 7), new Vector(4, 4));
        final float expected = 60;
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void testAdd() {
        final ReadOnlyVector result = Vector.add(new Vector(5, 4), new Vector(3, 2));
        final ReadOnlyVector expected = new Vector(8, 6);
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
        final ReadOnlyVector result2 = Vector.add(new Vector(5, 4), new Vector(-3, 2));
        final ReadOnlyVector expected2 = new Vector(2, 6);
        assertEquals(expected2.x(), result2.x(), 0.001);
        assertEquals(expected2.y(), result2.y(), 0.001);
    }

    @Test
    public void testSubtract() {
        Vector vector = Vector.subtract(new Vector(5, 4), new Vector(3, 2));
        assertEquals(2, vector.x(), 0.001);
        assertEquals(2, vector.y(), 0.001);
        vector = Vector.subtract(new Vector(5, 4), new Vector(-3, 2));
        assertEquals(8, vector.x(), 0.001);
        assertEquals(2, vector.y(), 0.001);
    }

    @Test
    public void testPointToPointVector_Vector_Vector() {
        Vector vector = Vector.pointToPointVector(new Vector(4, 5), new Vector(7, 2));
        assertEquals(3, vector.x(), 0.001);
        assertEquals(-3, vector.y(), 0.001);
    }
    
    @Test
    public void testEquals() {
        ReadOnlyVector vector = new Vector(7, 2);
        ReadOnlyVector vector_copy = vector;
        ReadOnlyVector vector_same = new Vector(7, 2);
        ReadOnlyVector vector_diff = new Vector(7.2f, 3);
        assert (vector.equals(vector_copy));
        assert (vector.equals(vector_same));
        assert (!vector.equals(vector_diff));
    }

    @Test
    public void testToArray() {
        final float[] array = new Vector(1, 2).toArray();
        assertEquals(1, array[0], 0.001);
        assertEquals(2, array[1], 0.001);
    }

    @Test
    public void testToPoint() {
        final ReadOnlyPoint point = new Vector(1, 2).toPoint();
        assertEquals(1, point.x(), 0.001);
        assertEquals(2, point.y(), 0.001);
    }

    @Test
    public void testToString() {
        assertEquals("(1.0, 2.0)", new Vector(1, 2).toString());
    }
}
