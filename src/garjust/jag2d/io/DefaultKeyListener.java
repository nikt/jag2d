package garjust.jag2d.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 *
 * @author Justin
 */
public class DefaultKeyListener implements KeyListener {

    private boolean[] keys;
    private char LastKeyTyped;
    private boolean OldKeyTyped;
    private boolean WaitingForKeyPress;

    /**
     *
     */
    public DefaultKeyListener() {
        keys = new boolean[100];
        OldKeyTyped = false;
        WaitingForKeyPress = false;
    }

    /**
     *
     *
     * @param e
     */
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        OldKeyTyped = false;
        LastKeyTyped = e.getKeyChar();
    }

    /**
     *
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        if (WaitingForKeyPress) {
            return;
        }
        keys[e.getKeyCode()] = true;
//    System.out.println(e.getKeyCode()+" / "+e.getKeyChar()+" // Pressed");
    }

    /**
     *
     *
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        if (WaitingForKeyPress) {
            return;
        }
        keys[e.getKeyCode()] = false;
//    System.out.println(e.getKeyCode()+" / "+e.getKeyChar()+" // Released");
    }

    public boolean isKeyPressed(int key_code) {
        return keys[key_code];
    }

    public char getLastKeyTyped() {
        OldKeyTyped = true;
        return LastKeyTyped;
    }

    public boolean getOldKeyTyped() {
        return OldKeyTyped;
    }

    public void setWaitingForKeyPress(boolean bool) {
        WaitingForKeyPress = bool;
    }

    public boolean getWaitingForKeyPress() {
        return WaitingForKeyPress;
    }
}