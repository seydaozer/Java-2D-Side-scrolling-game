import java.awt.Graphics;

/**
 * This class represents the power ups of the game.
 */
public abstract class Powerup extends Immobile {
    /**
     * This is default value of the width powerup's image.
     */
    public static final int DEFAULT_WIDTH = 32;
    /**
     * This is default value of the height powerup's image.
     */
    public static final int DEFAULT_HEIGHT = 32;
    /**
     * This is type of the power up. (A (0), B (1), C (2), D (3))
     */
    protected int type;
    /**
     * This variable is true if the player acquires the power up, but
     * it is false of the player does not acquire the power up.
     */
    protected boolean acquired;

    /**
     * Powerup Constructor
     * @param game Game object of the current game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public Powerup(Game game, float x, float y) {
        super(game, x, y);
        type = -1;
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        acquired = false;
    }

    /**
     * This function draws the image of the power up
     * @param g Graphics object is used to draw power up image
     */
    public void render(Graphics g) {
        if(!acquired)
            g.drawImage(Assets.powerups[type], (int) x, (int) y, width, height, null);
    }

    /**
     * Gets the score multiplier of the power up.
     * @return the score multiplier
     */
    public abstract int scoreMultiplier();

    /**
     * Gets the type of the power up
     * @return the current type
     */
    public int getType() {
        return type;
    }

    /**
     * Gets the name of the power up
     * @return the name of the power up
     */
    public String getName(){
        return "unknown";
    }

    /**
     * Sets the acquired variable
     * @param acquired the new value of acquired variable
     */
    public void setAcquired(boolean acquired) {
        this.acquired = acquired;
    }
}