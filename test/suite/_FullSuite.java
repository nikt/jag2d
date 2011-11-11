package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Justin Garbutt
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    jag2d.unit.geometry._GeometrySuite.class,
    jag2d.unit.geometry.util.PointListTest.class
})
public class _FullSuite {
}
