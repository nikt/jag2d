package garjust.jag2d.window;

import java.awt.Dimension;

/**
 *
 * @author Justin Garbutt
 */
public class WindowDimension {
    
    private final int width;
    private final int height;
    
    public WindowDimension(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
    
    public int width() {
        return width;
    }
    
    public int height() {
        return height;
    }
    
    public Dimension toDimension() {
        return new Dimension(width, height);
    }
}
