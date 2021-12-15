import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * This class represents the player of the game.
 */
public class Player extends Entity {
    /**
     * This is the default value of the player's life.
     */
    public static final int DEFAULT_LIFE = 3;
    /**
     * This is default value of the width player's image.
     */
    public static final int DEFAULT_WIDTH = 60;
    /**
     * This is default value of the height player's image.
     */
    public static final int DEFAULT_HEIGHT = 64;
    /**
     * This is height of the background's floor. It is constant, so it is a final variable.
     */
    private final int floorHeight;
    /**
     * This is the value of the player's life.
     */
    private int life;
    /**
     * This is x-coordinate.
     * Using this variable, it is checked whether the player is in the half of the window.
     */
    private float halfX;
    /**
     * This is x-coordinate.
     * By using this variable, the continuity of the 2 images printed on the screen for the background is provided.
     */
    private float endX;
    /**
     * This is fixed x-coordinate to draw the player image.
     */
    private final float fixedX;
    /**
     * This is jump behavior of the player.
     * It is a low jump or high jump.
     */
    private JumpBehavior jumpBehavior;
    /**
     * This is jump strength of the player.
     * This depends on the jump mode.
     */
    private float jumpStrength;
    /**
     * This is a list of power ups acquired by the player.
     */
    private LinkedList<Powerup> powerups;
    /**
     * This is the value of points of the player.
     */
    private long points;
    /**
     * This is the power factor that player earns from power ups.
     */
    private int powerFactor;

    /**
     * Player Constructor
     * @param game Game object of the current game
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public Player(Game game, float x, float y){
        super(game, x, y);
        life = DEFAULT_LIFE;
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;

        floorHeight = 210;

        halfX = 0;
        endX = 700;
        fixedX = x;

        jumpBehavior = new LowJump();
        jumpStrength = 0;

        powerups = new LinkedList<>();
        powerups.add(new InitialPowerup(game, 0,0));
        points = 0;
        powerFactor = 1;
    }

    /**
     * This function gets key inputs and updates the coordinates of the player
     */
    @Override
    public void tick() {
        getInput();
        move();
    }

    /**
     * This function gets key inputs for the right and jump movements
     */
    private void getInput(){
        xMove = 0;

        // right
        if(game.getKeyManager().right)
            xMove = speed;

        // jump
        if(game.getKeyManager().space && y >= floorHeight) {
            jumpStrength = jumpBehavior.jump();
            GameState.messages.addMessage(jumpBehavior.getType());
        }
    }

    /**
     * This function updates the coordinates of the player
     */
    private void move(){
        x += xMove;
        halfX += xMove;
        endX += xMove;

        y -= jumpStrength;
        jumpStrength -= 1;
        if (y >= floorHeight) y = floorHeight;
    }

    /**
     * This function draws the image of the player
     * @param g Graphics object is used to draw player image
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) fixedX, (int) y, width, height, null);
        //g.fillRect((int) fixedX + 16, (int) (y+12), 29, 52); // collision bolgesi
    }

    /**
     * This function gets the bounds of the player
     * @return a rectangle according to the player properties(width, height, x, y)
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle( (int) fixedX + 16, (int) y + 12, 29, 52);
    }

    /**
     * This functions decreases the player's life by 1.
     */
    public void loseLife(){
        life--;
        if(life <= 0)
            life = 0;
    }

    /**
     * This function add the new acquired power up into list of the acquired power ups.
     * @param type the type of the new power up
     */
    public void addPowerup(int type){
        if(type == 3) { // Type D power up
            TypeD temp = new TypeD(game, this, 0, 0);
            GameState.messages.addMessage("acquired " + temp.getName());
            temp.acquired();
        }
        else { // Type A, Type B, Type C power ups
            if (type == 0)
                powerups.add(new TypeA(game, powerups.getLast(), 0, 0));
            else if (type == 1)
                powerups.add(new TypeB(game, powerups.getLast(), 0, 0));
            else if (type == 2)
                powerups.add(new TypeC(game, powerups.getLast(), 0, 0));

            // I used this variable to print the previous power factor.
            int power = powerFactor;
            // Updating the power factor based on last acquired power up.
            updatePowerFactor();
            GameState.messages.addMessage("acquired " + powerups.getLast().getName() +
                    ". Current power factor = " + power + " and New power factor = " + powerFactor);
        }
    }

    /**
     * This function updates the player's power factor based on last acquired power up.
     */
    private void updatePowerFactor(){
        powerFactor = powerups.getLast().scoreMultiplier();
    }

    /**
     * This function updates the player's points.
     * If the player's jump that is over a monster is successful, the player earns the points that are equal to the power factor.
     */
    public void earnPoints(){
        points += powerFactor;
    }

    /**
     * This function changes the player's jump mode. (When the player acquires type D power up.)
     * @param newJumpBehavior the new jump mode
     */
    public void setJumpBehavior(JumpBehavior newJumpBehavior) {
        this.jumpBehavior = newJumpBehavior;
    }

    /**
     * Gets the current jump behavior of the player
     * @return the current jump behavior
     */
    public JumpBehavior getJumpBehavior() {
        return jumpBehavior;
    }

    /**
     * Gets the life of the player
     * @return the current life of the player
     */
    public int getLife(){
        return life;
    }

    /**
     * Sets the half coordinate of the player
     * @param halfX the new value of the half coordinate
     */
    public void setHalfX(float halfX){
        this.halfX = halfX;
    }

    /**
     * Gets the half coordinate of the player
     * @return the current value of half coordinate
     */
    public float getHalfX(){
        return halfX;
    }

    /**
     * Sets the end coordinate of the player
     * @param endX the new value of the end coordinate
     */
    public void setEndX(float endX){
        this.endX = endX;
    }

    /**
     * Gets the end coordinate of the player
     * @return the current value of end coordinate
     */
    public float getEndX(){
        return endX;
    }

    /**
     * Gets the player's points
     * @return points the current points
     */
    public long getPoints() {
        return points;
    }

    /**
     * Gets the power factor of the player
     * @return the current power factor
     */
    public int getPowerFactor() {
        return powerFactor;
    }

    /**
     * Gets the fixed x-coordinate of the player
     * @return the foxed x-coordinate
     */
    public float getFixedX() {
        return fixedX;
    }

}
