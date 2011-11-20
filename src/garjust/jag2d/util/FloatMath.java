package garjust.jag2d.util;

/**
 *
 * @author Justin Garbutt
 */
public class FloatMath {

    public static final float E = (float) Math.E;
    public static final float PI = (float) Math.PI;

    private FloatMath() {
    }

    public static float sin(final float angle) {
        return (float) Math.sin(angle);
    }

    public static float cos(final float angle) {
        return (float) Math.cos(angle);
    }

    public static float tan(final float angle) {
        return (float) Math.tan(angle);
    }

    public static float asin(final float value) {
        return (float) Math.asin(value);
    }

    public static float acos(final float value) {
        return (float) Math.acos(value);
    }

    public static float atan(final float value) {
        return (float) Math.atan(value);
    }

    public static float sqrt(final float value) {
        return (float) Math.sqrt(value);
    }
}
