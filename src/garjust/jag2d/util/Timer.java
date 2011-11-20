package garjust.jag2d.util;

/**
 *
 * @author Justin Garbutt
 */
public interface Timer {

    /**
     *
     */
    public void reset();

    /**
     *
     * @return
     */
    public float update();

    /**
     * Returns the instantaneous frames per second value
     * @return The instantaneous FPS
     */
    public float fps();

    /**
     * Returns time passed between the last two updates
     * @return
     */
    public float delta();

    /**
     * Returns the total time that has elapsed since the last reset;
     * @return
     */
    public float time();
}
