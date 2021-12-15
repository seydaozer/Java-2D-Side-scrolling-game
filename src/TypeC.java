/**
 * TypeC Class
 * The Class represents the type C power up of the game.
 */
public class TypeC extends PowerupDecorator {

    /**
     * TypeC Constructor
     * @param game Game object of the current game
     * @param powerup the power up to be decorated
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public TypeC(Game game, Powerup powerup, float x, float y) {
        super(game, x, y);
        this.powerup = powerup;
        type = 2;
    }

    /**
     * Gets the score multiplier of the power up C.
     * @return the score multiplier
     */
    @Override
    public int scoreMultiplier() {
        return 10 * powerup.scoreMultiplier();
    }

    /**
     * Gets the name of the power up C
     * @return the name of the power up C
     */
    @Override
    public String getName() {
        return "type C";
    }
}