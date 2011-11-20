package garjust.jag2d.geometry.util;

import garjust.jag2d.geometry.Vector;

import java.util.ArrayList;

/**
 *
 * @author Justin Garbutt
 */
public class VectorList extends ArrayList<Vector> {

    public VectorList() {
        super();
    }

    public VectorList(int size) {
        super(size);
    }

    public VectorList(VectorList vectors) {
        super(vectors.size());
        for(Vector vector : vectors) {
            add(vector);
        }
    }

    public int[][] getCoordinateMatrix() {
        int[][] matrix = new int[2][size()];
        int i = 0;
        for(Vector vector: this) {
            Vector drawable = vector.snap();
            matrix[0][i] = (int)drawable.x();
            matrix[1][i] = (int)drawable.y();
            i++;
        }
        return matrix;
    }
}
