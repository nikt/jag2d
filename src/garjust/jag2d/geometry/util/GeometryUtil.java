/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package garjust.jag2d.geometry.util;

/**
 *
 * @author t_garbj
 */
public class GeometryUtil {

    /**
     * Recursively fixes the given angle to be within 0 -> 2*PI radians
     *
     * @param radians The given angle
     * @return An angle between [0, 2*PI] radians
     */
    public static float reduceAngle(float radians) {
        if (radians > Math.PI * 2) {
            return reduceAngle(radians - (float) Math.PI * 2);
        } else if (radians < 0) {
            return reduceAngle(radians + (float) Math.PI * 2);
        }
        return radians;
    }
}
