import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is used to listen key inputs.
 */
public class MouseManager extends MouseAdapter {
    /**
     * This variable represents the start button.
     * Its value becomes true, when start button is pressed.
     * Its value becomes false, when start button is released.
     */
    public boolean start;
    /**
     * This variable represents the exit button.
     * Its value becomes true, when exit button is pressed.
     * Its value becomes false, when exit button is released.
     */
    public boolean exit;
    /**
     * This variable represents the pause button.
     * Its value becomes true, when pause button is pressed.
     * Its value becomes false, when pause button is released.
     */
    public boolean pause;
    /**
     * This variable represents the resume button.
     * Its value becomes true, when resume button is pressed.
     * Its value becomes false, when resume button is released.
     */
    public boolean resume;

    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        // Menu State Buttons
        if(mx >= 300 && mx <= 400){
            // Start button
            if(my >= 140 && my <= 180)
                start = true;
            // Exit button
            else if(my >= 190 && my <= 230)
                exit = true;
        }

        // Game State Buttons
        if(mx >= 625 && mx <= 665){
            if(my >= 15 && my <= 55)
                pause = true;
        }
        if(mx >= 325 && mx <= 375){
            if(my >= 150 && my <= 200)
                resume = true;
        }

    }

    /**
     * Invoked when a mouse button has been released on a component.
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        start = false;
        exit = false;
        pause = false;
        resume = false;
    }

}
