package garjust.jag2d.io;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Point;

/**
 *
 * @author Justin
 */
public class DefaultMouseMotionListener implements MouseMotionListener {

    private Point mouse;

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        mouse = e.getPoint();
    }

    public int getMouseX(){
        return mouse.x;
    }

    public int getMouseY(){
        return mouse.y;
    }
}