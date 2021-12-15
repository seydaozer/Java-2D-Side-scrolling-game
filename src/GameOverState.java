import java.awt.Graphics;

/**
 * GameOverState Class
 * The Class is the game over state of the game.
 */
public class GameOverState extends State {

    /**
     * GameOverState Constructor
     * @param game Game object of the current game
     */
    public GameOverState(Game game){
        super(game);
    }

    /**
     * It does not anything.
     */
    @Override
    public void tick() { }

    /**
     * This function draws the background images and "Game Over!".
     * @param g Graphics object is used to draw
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, 700, 365, null);
        g.drawImage(Assets.gameOver, 240, 90, 250, 150, null);
    }
}
