package garjust.jag2d.geometry.util;

import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.ReadOnlyPoint;

import java.util.ArrayList;

/**
 *
 * @author Justin Garbutt
 */
public final class PointList extends ArrayList<Point> {
    
    public PointList() {
        super();
    }

    public PointList(final int size) {
        super(size);
    }

    public PointList(final PointList points) {
        super(points.size());
        for(ReadOnlyPoint point : points) {
            add(new Point(point));
        }
    }

    public int[][] getCoordinateMatrix() {
        final int[][] matrix = new int[2][size()];
        int i = 0;
        for(Point point: this) {
            matrix[0][i] = point.getSnappedX();
            matrix[1][i] = point.getSnappedY();
            i++;
        }
        return matrix;
    }
}