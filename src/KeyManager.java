import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class is used to listen key inputs.
 */
public class KeyManager extends KeyAdapter {
    /**
     * This array contains the keys of the keyboard.
     * The pressed key becomes true. The released key becomes false.
     */
    private boolean[] keys;
    /**
     * This variable represents the space key.
     * Its value becomes true, when space key is pressed.
     * Its value becomes false, when space key is released.
     */
    public boolean space;
    /**
     * This variable represents the D key.
     * Its value becomes true, when D key is pressed.
     * Its value becomes false, when D key is released.
     */
    public boolean right;
    /**
     * This variable represents the up key.
     * Its value becomes true, when up key is pressed.
     * Its value becomes false, when up key is released.
     */
    public boolean up;
    /**
     * This variable represents the down key.
     * Its value becomes true, when down key is pressed.
     * Its value becomes false, when down key is released.
     */
    public boolean down;
    /**
     * This variable represents the enter key.
     * Its value becomes true, when enter key is pressed.
     * Its value becomes false, when enter key is released.
     */
    public boolean enter;

    /**
     * KeyManager Constructor
     */
    public KeyManager(){
        keys = new boolean[256];
    }

    /**
     * This function takes the inputs of the required keys.
     */
    public void tick(){
        // for player
        space = keys[KeyEvent.VK_SPACE];
        right = keys[KeyEvent.VK_D];
        //for menu
        enter = keys[KeyEvent.VK_ENTER];
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
    }

    /**
     * Invoked when a key has been pressed.
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    /**
     * Invoked when a key has been released.
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
