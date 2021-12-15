import java.awt.Graphics;

/**
 * This class represents the initial power up of the game player.
 * Its score multiplier value is 1 as it is the initial power up.
 */
public class InitialPowerup extends Powerup {

    /**
     * InitialPowerup Constructor
     * @param game Game object of the current game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public InitialPowerup(Game game, float x, float y) {
        super(game, x, y);
        type = -1;
    }

    /**
     * This is not used. The initial power up will not be drawn.
     * This function draws the image of the power up
     * @param g Graphics object is used to draw power up image
     */
    @Override
    public void render(Graphics g) { }

    /**
     * Gets the score multiplier of the initial power up.
     * @return the score multiplier
     */
    @Override
    public int scoreMultiplier() {
        return 1;
    }

}