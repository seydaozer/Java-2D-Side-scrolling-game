import java.awt.Rectangle;

/**
 * This class represents the immobile entities of the game.
 * They are : Monster, Powerup.
 */
public abstract class Immobile extends Entity {

    /**
     * Immobile Constructor
     * @param game Game object of the current game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public Immobile(Game game, float x, float y){
        super(game, x, y);
    }

    /**
     * This function gets key inputs and updates the coordinates of the immobile entity
     */
    @Override
    public void tick() {
        getInput();
        move();
    }

    /**
     * This function gets key inputs for the left movement
     */
    protected void getInput(){
        xMove = 0;

        if(game.getKeyManager().right)
            xMove = -speed;
    }

    /**
     * This function updates the x-coordinate of the immobile entity
     */
    protected void move() {
        x += xMove;
    }

    /**
     * This function gets the bounds of the immobile entity
     * @return a rectangle according to the immobile entity properties(width, height, x, y)
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle( (int) x, (int) y, width, height);
    }
}
