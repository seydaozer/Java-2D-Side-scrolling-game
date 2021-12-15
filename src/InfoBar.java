import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * This class represents the information bar in the upper left corner of the game window.
 * It includes : the current life of the player, the current points of the player, and the FPS of the game.
 */
public class InfoBar {
    /**
     * This class is the information bar of the Game object.
     * The game is used to get the FPS value.
     */
    private Game game;
    /**
     * The current player of the game.
     * The player is used to get the information about the points and life.
     */
    private Player player;
    /**
     * The x-coordinate of the InfoBar.
     */
    private float x;
    /**
     * The y-coordinate of the InfoBar.
     */
    private float y;
    /**
     * The width of the background image. The width is constant, so it is a final variable.
     */
    private final int width;
    /**
     * The height of the background image. The height is constant, so it is a final variable.
     */
    private final int height;
    /**
     * This is color of the String to be drawn
     */
    private Color color;
    /**
     * This is font of the String to be drawn
     */
    private Font font;
    /**
     * This variable is the information of the current player's life
     */
    private String lifeInfo;
    /**
     * This variable is the information of the current player's points
     */
    private String pointsInfo;
    /**
     * This variable is the information of the game's FPS
     */
    private String FPSinfo;

    /**
     * InfoBar Constructor
     * @param game current game
     * @param player current player of the game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public InfoBar(Game game, Player player, float x, float y){
        this.game = game;
        this.player = player;
        this.x = x;
        this.y = y;
        width = 120;
        height = 70;
        color = Color.white;
        font = new Font("Arial", Font.PLAIN, 15);
        lifeInfo = "";
        pointsInfo = "";
        FPSinfo = "";
    }

    /**
     * This function gets the life and points of the player and the FPS value of the game.
     */
    public void tick(){
        lifeInfo = String.valueOf(player.getLife());
        pointsInfo = String.valueOf(player.getPoints());
        FPSinfo = String.valueOf(game.getFPS_value());
    }

    /**
     * This function draws the image of the information bar and the information about points, life and FPS.
     * @param g Graphics object is used to draw
     */
    public void render(Graphics g) {
        g.drawImage(Assets.bar, (int) x, (int) y, width, height,null);
        g.setColor(color);
        g.setFont(font);
        g.drawString(lifeInfo, 65, 22);
        g.drawString(pointsInfo, 65, 44);
        g.drawString(FPSinfo, 65, 66);
    }

}
