import java.awt.image.BufferedImage;

/**
 * This class contains the necessary images for the game.
 */
public class Assets {
    /**
     * The BufferedImage used for background image of the game.
     */
    public static BufferedImage background;
    /**
     * The BufferedImage used for bar image of the game.
     * The bar image contains the life of the player, the point of the player, and the FPS of the game.
     */
    public static BufferedImage bar;
    /**
     * The BufferedImage used for monster image of the game.
     */
    public static BufferedImage monster;
    /**
     * The BufferedImage used for player image of the game.
     */
    public static BufferedImage player;
    /**
     * The BufferedImage array contains powerup images of the game.
     * Powerup Types: Type A, Type B, Type C, Type D.
     * Type A: x2
     * Type B: x5
     * Type C: x10
     * Type D: change jump mode
     */
    public static BufferedImage[] powerups;
    /**
     * The BufferedImage used for start button image of the game.
     */
    public static BufferedImage startButton;
    /**
     * The BufferedImage used for exit button image of the game.
     */
    public static BufferedImage exitButton;
    /**
     * The BufferedImage used for pause button image of the game.
     */
    public static BufferedImage pauseButton;
    /**
     * The BufferedImage used for resume button image of the game.
     */
    public static BufferedImage resumeButton;
    /**
     * The BufferedImage used for game over text image of the game.
     */
    public static BufferedImage gameOver;

    /**
     * The init function loads images for use in the game.
     */
    public static void init(){
        background = ImageLoader.loadImage("background.png");
        bar = ImageLoader.loadImage("bar.png");
        monster = ImageLoader.loadImage("monster.png");
        player = ImageLoader.loadImage("mouse.png");

        powerups = new BufferedImage[4];
        powerups[0] = ImageLoader.loadImage("Atype.png");
        powerups[1] = ImageLoader.loadImage("Btype.png");
        powerups[2] = ImageLoader.loadImage("Ctype.png");
        powerups[3] = ImageLoader.loadImage("Dtype.png");

        startButton = ImageLoader.loadImage("startButton.png");
        exitButton = ImageLoader.loadImage("exitButton.png");
        pauseButton = ImageLoader.loadImage("pauseButton.png");
        resumeButton = ImageLoader.loadImage("resumeButton.png");

        gameOver = ImageLoader.loadImage("gameOver.png");
    }

}
