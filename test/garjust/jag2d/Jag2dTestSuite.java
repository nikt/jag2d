package garjust.jag2d;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Justin Garbutt
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    garjust.jag2d.geometry.GeometryTestSuite.class,
    garjust.jag2d.geometry.util.GeometryUtilTestSuite.class
})
public class Jag2dTestSuite {
}
