/**
 * TypeB Class
 * The Class represents the type B power up of the game.
 */
public class TypeB extends PowerupDecorator {

    /**
     * TypeB Constructor
     * @param game Game object of the current game
     * @param powerup the power up to be decorated
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public TypeB(Game game, Powerup powerup, float x, float y) {
        super(game, x, y);
        this.powerup = powerup;
        type = 1;
    }

    /**
     * Gets the score multiplier of the power up B.
     * @return the score multiplier
     */
    @Override
    public int scoreMultiplier() {
        return 5 * powerup.scoreMultiplier();
    }

    /**
     * Gets the name of the power up B
     * @return the name of the power up B
     */
    @Override
    public String getName() {
        return "type B";
    }

}