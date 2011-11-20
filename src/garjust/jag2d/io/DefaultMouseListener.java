package garjust.jag2d.io;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;

/**
 *
 * @author Justin
 */
public class DefaultMouseListener implements MouseListener {

    private Point ClickPoint;
    private boolean NewClick;

    public DefaultMouseListener() {
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     */
    public void mouseClicked(MouseEvent e) {
        NewClick = true;
        ClickPoint = e.getPoint();
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Invoked when a mouse button has been released on a component.
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Invoked when the mouse enters a component.
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Invoked when the mouse exits a component.
     */
    public void mouseExited(MouseEvent e) {
    }

    public int[] getClickPoint() {
        if (NewClick) {
            NewClick = false;
            int[] point = {ClickPoint.x, ClickPoint.y};
            return point;
        }
        return null;
    }
}
