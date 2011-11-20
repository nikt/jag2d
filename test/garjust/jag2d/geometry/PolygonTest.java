package garjust.jag2d.geometry;

import garjust.jag2d.collision.BoundingBox;
import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.Polygon;
import garjust.jag2d.geometry.ReadOnlyPolygon;
import garjust.jag2d.geometry.util.PointList;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Justin Garbutt
 */
public class PolygonTest {

    private static final PointList polygon1 = new PointList();
    private static final PointList polygon2 = new PointList();

    @BeforeClass
    public static void setUpClass() throws Exception {
        polygon1.add(new Point(0, 0));
        polygon1.add(new Point(10, 0));
        polygon1.add(new Point(10, 10));
        polygon1.add(new Point(0, 10));

        polygon2.add(new Point(3, 5));
        polygon2.add(new Point(7, 4));
        polygon2.add(new Point(-3, -3));
    }

    @Test
    public void testCopyConstructor() {
        final ReadOnlyPolygon polygon = new Polygon(polygon1);
        final ReadOnlyPolygon copy = new Polygon(polygon);
        assert (polygon != copy);
        assert (polygon.vertices() != copy.vertices());
        assert (polygon.centre() != copy.centre());
        assert (polygon.hull() != copy.hull());
    }

    @Test
    public void testVertices() {
        final PointList expected = polygon1;
        final PointList result = new Polygon(polygon1).vertices();
        assert (result != expected);
        assert (result.equals(expected));
        final PointList expected2 = polygon2;
        final PointList result2 = new Polygon(polygon2).vertices();
        assert (result2 != expected2);
        assert (result2.equals(expected2));
    }

    @Test
    // TODO using "f" in expected2 constructor
    public void testCentre() {
        final Point expected = new Point(5, 5);
        final Point result = new Polygon(polygon1).centre();
        assertEquals(expected.x(), result.x(), 0.001);
        assertEquals(expected.y(), result.y(), 0.001);
        final Point expected2 = new Point(7f / 3f, 2);
        System.err.println(expected2);
        final Point result2 = new Polygon(polygon2).centre();
        assertEquals(expected2.x(), result2.x(), 0.001);
        assertEquals(expected2.y(), result2.y(), 0.001);
    }

    @Test
    public void testVertices_pointlist() {
        final Polygon polygon_org = new Polygon(polygon1);
        final PointList expected_old = polygon1;
        final PointList expected_new = polygon2;
        final PointList result_old = polygon_org.vertices(polygon2);
        final PointList result_new = polygon_org.vertices();
        assert (result_old != expected_old);
        assert (result_old.equals(expected_old));
        assert (result_new != expected_new);
        assert (result_new.equals(expected_new));
    }

    @Test
    public void testResetCentre() {
        final Point expected1 = new Polygon(polygon2).centre();
        final Polygon result = new Polygon(polygon2);
        result.centre();
        assert(expected1.equals(result.resetCentre()));
    }

    @Test
    public void testResetHull() {
        final Polygon expected1 = new Polygon(polygon2).hull();
        final Polygon result = new Polygon(polygon2);
        result.hull();
        assert(expected1.equals(result.resetHull()));
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
        final ReadOnlyPolygon result = new Polygon(polygon2).scale(2);
        final PointList expected = new PointList(3);
        expected.add(new Point(3.666666667f, 8));
        expected.add(new Point(11.6666667f, 6));
        expected.add(new Point(-8.333333333f, -8));
        assert (result.vertices().get(0).equals(expected.get(0)));
        assert (result.vertices().get(1).equals(expected.get(1)));
        assert (result.vertices().get(2).equals(expected.get(2)));
    }

    @Test
    public void testTranslate() {
        final ReadOnlyPolygon result = new Polygon(polygon2).translate(3, 6);
        final PointList expected = new PointList(3);
        expected.add(new Point(6, 11));
        expected.add(new Point(10, 10));
        expected.add(new Point(0, 3));
        assert (result.vertices().get(0).equals(expected.get(0)));
        assert (result.vertices().get(1).equals(expected.get(1)));
        assert (result.vertices().get(2).equals(expected.get(2)));
    }

    @Test
    public void testBound() {
        final BoundingBox expected = new BoundingBox(new Point(), new Point(10, 10));
        final BoundingBox result = new Polygon(polygon1).bound();
        assert (BoundingBox.intersection(expected, result));
    }

    @Test
    public void testToString() {
        assertEquals("[Polygon: (0.0, 0.0) (10.0, 0.0) (10.0, 10.0) (0.0, 10.0)]", new Polygon(polygon1).toString());
    }
}
