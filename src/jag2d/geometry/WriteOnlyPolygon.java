package jag2d.geometry;

import jag2d.geometry.util.PointList;

/**
 *
 * @author jagarbut
 */
public interface WriteOnlyPolygon {

    public PointList vertices(final PointList new_vertices);
}
