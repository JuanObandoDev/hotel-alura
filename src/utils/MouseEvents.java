package utils;

import java.awt.event.MouseEvent;

public class MouseEvents {
    public int[] headerMousePressed(MouseEvent e) {
        return new int[] { e.getX(), e.getY() };
    }

    public int[] headerMouseDragged(MouseEvent e, int[] mouseCoords) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        return (new int[] { x - mouseCoords[0], y - mouseCoords[1] });
    }
}
