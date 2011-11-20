package garjust.jag2d.geometry.util;

import garjust.jag2d.geometry.Polygon;

import java.util.ArrayList;

/**
 *
 * @author Justin Garbutt
 */
public class PolygonList extends ArrayList<Polygon> {
        
    public PolygonList() {
        super();
    }
    
    public PolygonList(final int size) {
        super(size);
    }
}
