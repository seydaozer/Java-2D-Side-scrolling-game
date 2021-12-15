/**
 *
 */
public class TypeD extends Powerup{
    /**
     * The player that acquired this power up
     */
    private Player player;

    /**
     * TypeD Constructor
     * @param game Game object of the current game
     * @param player the current player of the game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public TypeD(Game game, Player player, float x, float y){
        super(game, x, y);
        this.player = player;
        type = 3;
    }

    /**
     * This class does not use this function. It does not have any score multiplier.
     * Gets the score multiplier of the power up.
     * @return the score multiplier
     */
    @Override
    public int scoreMultiplier() {
        return 0;
    }

    /**
     * Gets the name of the power up D
     * @return the name of the power up D
     */
    @Override
    public String getName() {
        return "type D";
    }

    /**
     * This function changes the player's jump mode.
     * (from low to high or from high to low)
     */
    public void acquired() {
        if(player.getJumpBehavior() instanceof HighJump) {
            player.setJumpBehavior(new LowJump());
            GameState.messages.addMessage("Change jump mode high to low.");
        }
        else if(player.getJumpBehavior() instanceof LowJump){
            player.setJumpBehavior(new HighJump());
            GameState.messages.addMessage("Change jump mode low to high.");
        }
    }
}
