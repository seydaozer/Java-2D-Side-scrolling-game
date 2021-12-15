import java.awt.Graphics;

/**
 * This class represents the monster of the game.
 */
public class Monster extends Immobile {
    /**
     * This is default value of the width monster's image.
     */
    public static final int DEFAULT_WIDTH = 40;
    /**
     * This is default value of the height monster's image.
     */
    public static final int DEFAULT_HEIGHT = 30;
    /**
     * This variable is true if the player collides the monster, but
     * it is false of the player does not collide the monster.
     */
    private boolean collision;

    /**
     * Monster Constructor
     * @param game Game object of the current game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public Monster(Game game, float x, float y){
        super(game, x, y);
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        collision = false;
    }


    /**
     * This function draws the image of the monster
     * @param g Graphics object is used to draw monster image
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.monster, (int) x, (int) y, width, height, null);
    }

    /**
     * Sets the collision variable
     * @param collision the new value of the collision
     */
    public void setCollision(Boolean collision){
        this.collision = collision;
    }

    /**
     * Gets the collision variable
     * @return the current value of the collision
     */
    public boolean getCollision(){
        return collision;
    }
}
