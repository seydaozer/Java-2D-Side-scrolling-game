import java.awt.*;

/**
 * This class is the menu state of the game.
 * The menu contains Start and Exit buttons.
 */
public class MenuState extends State {
    /**
     * This is color of the title text to be drawn
     */
    private Color titleColor;
    /**
     * This is font of the title text to be drawn
     */
    private Font titleFont;

    /**
     * MenuState Constructor
     * @param game Game object of the current game
     */
    public MenuState(Game game){
        super(game);
        titleColor = Color.WHITE;
        titleFont = new Font("Century Gothic", Font.PLAIN, 20);
    }

    /**
     * The function gets the mouse inputs.
     */
    @Override
    public void tick() {
        if(game.getMouseManager().start) {
            setState(new GameState(game));
        }
        if(game.getMouseManager().exit) {
            System.exit(1);
        }

    }

    /**
     * This function draws the background images, game title and menu options.
     * @param g Graphics object is used to draw
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, 700, 365, null);

        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString(game.getTitle(), 300, 120);

        g.drawImage(Assets.startButton, 300, 140, 100, 40, null);
        g.drawImage(Assets.exitButton, 300, 190, 100, 40, null);

    }

}
