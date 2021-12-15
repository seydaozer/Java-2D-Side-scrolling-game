/**
 * PowerupDecorator Class
 */
public abstract class PowerupDecorator extends Powerup {
    /**
     * power up to be decorated
     */
    protected Powerup powerup;

    /**
     * PowerupDecorator Constructor
     * @param game Game object of the current game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public PowerupDecorator(Game game, float x, float y) {
        super(game, x, y);
    }

    /**
     * Gets the name of the power up
     * @return the name of the power up
     */
    public abstract String getName();
}