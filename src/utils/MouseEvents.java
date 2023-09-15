package utils;

import java.awt.event.MouseEvent;

/**
 * Class MouseEvents
 * this class is used to handle mouse events
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @see MouseEvent
 * 
 * @author JuanObandoDev
 */
public class MouseEvents {
    /**
     * Method that returns the coordinates of the mouse when it is pressed
     * 
     * @param e
     * @return int[] coordinates
     */
    public int[] headerMousePressed(MouseEvent e) {
        return new int[] { e.getX(), e.getY() };
    }

    /**
     * Method that returns the coordinates of the mouse when it is dragged
     * 
     * @param e
     * @param mouseCoords
     * @return int[] coordinates
     */
    public int[] headerMouseDragged(MouseEvent e, int[] mouseCoords) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        return (new int[] { x - mouseCoords[0], y - mouseCoords[1] });
    }
}
