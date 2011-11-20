package garjust.jag2d.util;

/**
 * Class handles the time elapsed in milliseconds(ms) and keeps track of change in time since last update()
 *
 * @author Justin
 */
public final class DefaultTimer implements Timer {

    private double delta;
    private double time_at_last_update;
    private double time_elapsed;

    /**
     * Constructs a new timer
     */
    public DefaultTimer() {
        reset();
    }

    /**
     *
     */
    public void reset() {
        delta = 0;
        time_at_last_update = System.currentTimeMillis();
        time_elapsed = 0;
    }

    /**
     *
     * @return
     */
    public float update() {
        delta = System.currentTimeMillis() - time_at_last_update;
        time_at_last_update = System.currentTimeMillis();
        time_elapsed += delta;
        return (float) delta;
    }

    /**
     * Returns the instantaneous frames per second value
     * @return The instantaneous FPS
     */
    public float fps() {
        return 1 / ((float) delta / 1000);
    }

    /**
     * Returns time passed between the last two updates
     * @return
     */
    public float delta() {
        return (float) delta;
    }

    /**
     * Returns the total time that has elapsed since the last reset;
     * @return
     */
    public float time() {
        return (float) time_elapsed;
    }

    /**
     * Throttles the application run speed
     * @param time Time in millisecond(ms) to delay thread
     */
    public static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println("ERROR: Delay exception > " + e);
        }
    }
}
