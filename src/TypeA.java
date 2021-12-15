/**
 * TypeA Class
 * The Class represents the type A power up of the game.
 */
public class TypeA extends PowerupDecorator {

    /**
     * TypeA Constructor
     * @param game Game object of the current game
     * @param powerup the power up to be decorated
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public TypeA(Game game, Powerup powerup, float x, float y) {
        super(game, x, y);
        this.powerup = powerup;
        type = 0;
    }

    /**
     * Gets the score multiplier of the power up A.
     * @return the score multiplier
     */
    @Override
    public int scoreMultiplier() {
        return 2 * powerup.scoreMultiplier();
    }

    /**
     * Gets the name of the power up A
     * @return the name of the power up A
     */
    @Override
    public String getName() {
        return "type A";
    }

}