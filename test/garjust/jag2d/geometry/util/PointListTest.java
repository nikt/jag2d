/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package garjust.jag2d.geometry.util;

import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.util.PointList;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jagarbut
 */
public class PointListTest {
    
    @Test
    public void testCopyConstructor() {
        final PointList list = new PointList();
        list.add(new Point(1, 1));
        list.add(new Point(2, 2));
        list.add(new Point(3, 3));
        list.add(new Point(4, 4));
        final PointList copy = new PointList(list);
        for(Point copy_point: copy) {
            for(Point list_point: list) {
                if(copy_point == list_point) {
                    fail("There were two points with the same address");
                }
            }
        }
    }
}
