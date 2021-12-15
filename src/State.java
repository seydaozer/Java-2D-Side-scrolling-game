import java.awt.Graphics;

/**
 * State Class
 * The Class represents the states of the game.
 * These states : Menu state, Game state, Game Over state.
 */
public abstract class State {
    /**
     * This is current game
     */
    protected Game game;
    /**
     * This is the current state of the game. It is static variable because it may change at any time.
     */
    public static State currentState = null;

    /**
     * State Constructor
     * @param game Game object of the current game
     */
    public State(Game game){
        this.game = game;
    }

    /**
     * This function updates the operations performed in the current state.
     */
    public abstract void tick();

    /**
     * This function draws the images and strings required in the current state.
     * @param g Graphics object is used to draw
     */
    public abstract void render(Graphics g);

    /**
     * Sets the current state of the game
     * @param state the new current state
     */
    public static void setState(State state){
        currentState = state;
    }

    /**
     * Gets the current state of the game
     * @return the current state
     */
    public static State getState(){
        return currentState;
    }
}
