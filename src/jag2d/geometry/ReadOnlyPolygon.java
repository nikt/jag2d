package jag2d.geometry;

import jag2d.geometry.util.PointList;

/**
 *
 * @author jagarbut
 */
public interface ReadOnlyPolygon {
    
    public PointList vertices();
    
    public Point centre();
    
    public Polygon hull();
}
