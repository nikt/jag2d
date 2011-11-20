package garjust.jag2d.window;

import garjust.jag2d.io.DefaultKeyListener;
import garjust.jag2d.io.DefaultMouseListener;
import garjust.jag2d.io.DefaultMouseMotionListener;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 * A basic window for graphics
 *
 * @author Justin
 */
public class DefaultWindow extends Canvas {

    private final JFrame frame;
    private final BufferStrategy bufferStrategy;
    private final WindowDimension dimensions;
    private Graphics2D graphics;
    // 
    private final DefaultKeyListener keylistener;
    private final DefaultMouseListener mouselistener;
    private final DefaultMouseMotionListener mousemotionlistener;

    /**
     * Initializes a window
     * Creates a JFrame to contain the class in (an extension of canvas)
     */
    public DefaultWindow(String window_name, WindowDimension dimensions, int buffer_strategies) {
        this.dimensions = dimensions;
        setSize(dimensions.toDimension());
        setIgnoreRepaint(true);
        setBackground(Color.black);
        this.frame = new JFrame();
        this.frame.setIgnoreRepaint(true);
        this.frame.setPreferredSize(dimensions.toDimension());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle(window_name);
        this.frame.setFocusTraversalKeysEnabled(false);
        this.frame.add((Canvas) this);
        this.frame.pack();
        this.frame.setResizable(false);
        this.frame.setVisible(true);
        this.keylistener = new DefaultKeyListener();
        addKeyListener(keylistener);
        this.mouselistener = new DefaultMouseListener();
        addMouseListener(mouselistener);
        this.mousemotionlistener = new DefaultMouseMotionListener();
        addMouseMotionListener(mousemotionlistener);
        requestFocus();
        createBufferStrategy(buffer_strategies);
        this.bufferStrategy = getBufferStrategy();
        this.graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
    }

    /**
     * Renders the offscreen buffer
     */
    public void renderBuffer() {
        graphics.dispose();
        bufferStrategy.show();
        graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
    }

    /**
     * Returns the graphics context to be drawn onto
     *
     * @return
     */
    @Override
    public Graphics2D getGraphics() {
        return graphics;
    }

    /**
     * Returns whether or not the specified key is pressed
     * @param key_code
     * @return
     */
    public boolean isKeyPressed(int key_code) {
        return keylistener.isKeyPressed(key_code);
    }

    public int[] getClickPoint() {
        return mouselistener.getClickPoint();
    }

    public int getMouseX() {
        return mousemotionlistener.getMouseX();
    }

    public int getMouseY() {
        return mousemotionlistener.getMouseY();
    }
}
