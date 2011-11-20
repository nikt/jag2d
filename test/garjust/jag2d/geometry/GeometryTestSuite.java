package garjust.jag2d.geometry;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Justin Garbutt
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
    garjust.jag2d.geometry.PointTest.class, 
    garjust.jag2d.geometry.PolygonTest.class,
    garjust.jag2d.geometry.RectangleTest.class, 
    garjust.jag2d.geometry.VectorTest.class,
})
public class GeometryTestSuite {
    
}
