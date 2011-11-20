package garjust.jag2d.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author Justin Garbutt
 */
public class GraphicsConfig {
    
    final private Color color;
    final private Stroke stroke;
    
    public GraphicsConfig(final Color color, final Stroke stroke) {
        this.color = color;
        this.stroke = stroke;
    }
    
    public GraphicsConfig(final Graphics2D graphics) {
        this.color = graphics.getColor();
        this.stroke = graphics.getStroke();
    }
    
    public Graphics2D set(final Graphics2D graphics) {
        graphics.setColor(color);
        graphics.setStroke(stroke);
        return graphics;
    }
}
