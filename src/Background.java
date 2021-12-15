import java.awt.Graphics;

/**
 * This class is responsible for the background image, its movement and continuity.
 */
public class Background {
    /**
     * This class is the background of the Game object.
     * The game is used to get key inputs.
     */
    private Game game;
    /**
     * This is current player in the game.
     * This object is used to control the position of the player on the background. The background is refreshed accordingly its position.
     */
    private Player player;
    /**
     * The width of the background image. The width is constant, so it is a final variable.
     */
    private final int width;
    /**
     * The height of the background image. The height is constant, so it is a final variable.
     */
    private final int height;
    /**
     * It is x-coordinate of the background. It is used to draw first image.
     */
    private float firstImageX;
    /**
     * It is x-coordinate of the background. It is used to draw second image.
     */
    private float secondImageX;
    /**
     * The y-coordinate of the background. The background has only left movement. The y coordinate is constant, so it is final variable.
     */
    private final float y;

    /**
     * Background Constructor
     * @param game current game
     * @param player current player of the game
     */
    public Background(Game game, Player player){
        this.game = game;
        this.player = player;
        width = 1000;
        height = 365;
        firstImageX = 0;
        secondImageX =  0;
        y = 0;
    }

    /**
     * This tick function gets the x-coordinate of the player and sets its own x-coordinates.
     */
    public void tick(){
        // controlling half of the background. It is used to draw second background image
        // if the player reached half of the frame, the player's half values set to 0.
        if((player.getX() - 340) % 2000 == 0)
            player.setHalfX(0);

        // controlling end of the background. It is used to draw first background image
        // if the player reached end of the image, the player's end value set to 0.
        if((player.getX() - 1340) % 2000 == 0)
            player.setEndX(0);

        // These values are limited to 700 because the width of the width of the game's window is 700.
        secondImageX = 700 - player.getHalfX();
        firstImageX = 700 - player.getEndX();
    }

    /**
     * This function draws background image continuously.
     * When the end of the first image is reached, the second image is drawn.
     * The background images drawn based on the player's position.
     * @param g Graphics object is used to draw background image
     */
    public void render(Graphics g){
        // draw first image
        g.drawImage(Assets.background, (int) firstImageX, (int) y, width, height,null);

        // draw the second image when the player reaches half of the first image
        // 340 = the x-coordinate of the player, when the end of the first image is reached
        if(player.getX() >= 340)
            g.drawImage(Assets.background, (int) secondImageX, (int) y, width, height, null);

        // draw pause button
        g.drawImage(Assets.pauseButton, 625, 15, 40,40,null);
    }

}
