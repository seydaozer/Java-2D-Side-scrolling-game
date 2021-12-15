import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * This class represents the game entities.
 * They are: Player, Immobile Entity (Monster and Powerup)
 */
public abstract class Entity {
    /**
     * This is default speed for entities
     */
    public static final float DEFAULT_SPEED = 5.0f;
    /**
     * This is current game
     */
    protected Game game;
    /**
     * This is x-coordinate for the entity
     */
    protected float x;
    /**
     * Tihs is y-coordinate for the entity
     */
    protected float y;
    // We are making them float because this is know we achieve smooth movement in our game.
    // It seems kind of strange because we cannot display only half of a pixel on our computer screen. We can only display whole pixels.
    // So why would not we do this an integer? Well we are doing this because the calculations in our game
    // are going to not be perfect integers and this is how we are going to achieve the smooth look of our game
    /**
     * This is movement of the entity on the x-coordinate.
     */
    protected float xMove;
    /**
     * This is movement of the entity on the y-coordinate.
     */
    protected float yMove;
    /**
     * This is speed of the entity.
     */
    protected float speed;
    /**
     * This is width of the entity.
     */
    protected int width;
    /**
     * This is height of the entity.
     */
    protected int height;

    /**
     * Entity Constructor
     * @param game Game object of the current game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public Entity(Game game, float x, float y){
        this.game = game;
        this.x = x;
        this.y = y;
        xMove = 0;
        yMove = 0;
        speed = DEFAULT_SPEED;
    }

    /**
     * This function gets key inputs and updates the coordinates of the entity
     */
    public abstract void tick();

    /**
     * This function draws the image of the entity
     * @param g Graphics object is used to draw entity image
     */
    public abstract void render(Graphics g);

    /**
     * This function gets the bounds of the entity
     * @return a rectangle according to the entity properties(width, height, x, y)
     */
    public abstract Rectangle getBounds();

    /**
     * Gets the x-coordinate
     * @return current the x-coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the x-coordinate
     * @param x new value of the x-coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets y-coordinate
     * @return current the y-coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the y-coordinate
     * @param y new value of the y-coordinate
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Gets the width of the entity
     * @return current width of the entity
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the entity
     * @param width new value of the width of the entity
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the height of the entity
     * @return current height of the entity
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the entity
     * @param height new value of the height of the entity
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
