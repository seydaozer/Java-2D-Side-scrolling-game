import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 * This class is the game state of the game.
 */
public class GameState extends State {
    /**
     * This is the current player of the game.
     */
    private Player player;
    /**
     * This is the background of the game state.
     */
    private Background background;
    /**
     * This is the information bar fo the game.
     */
    private InfoBar bar;
    /**
     * This is the list of all monsters in the game.
     */
    private LinkedList<Monster> monsters;
    /**
     * This is the list of all powerups in the game.
     */
    private LinkedList<Powerup> powerups;
    /**
     * This is the Message Window.
     * It includes the messages that are the information about player moves.
     */
    public static MessageArea messages;
    /**
     * This variable is initially false.
     * It becomes true if the player collides the monster.
     * When the monster is behind the player, its value will be false again.
     */
    private boolean collisionMonster;
    /**
     * This variable is initially false.
     * It becomes true if the player collides the powerup.
     * When the power up is behind the player, its value will be false again.
     */
    private boolean collisionPowerup;
    /**
     * This is the player's x-coordinate at the time it collides the monster.
     */
    private float collisionMX;
    /**
     * This is the player's x-coordinate at the time it collides the power up.
     */
    private float collisionPX;
    /**
     * The next monster based on the player's x-coordinate
     */
    Monster nextMonster;
    /**
     * The previous monster based on the player's x-coordinate
     */
    Monster prevMonster;
    /**
     * This variable is initially false.
     * It becomes true if the player presses the pause button.
     */
    private boolean paused;

    /**
     * GameState Constructor
     * @param game Game object of the current game
     */
    public GameState(Game game){
        super(game);
        player = new Player(game, 40, 210);
        background = new Background(game, player);
        bar = new InfoBar(game, player, 5,5);

        monsters = new LinkedList<>();
        monsters.add(new Monster(game, 300, 245));
        monsters.add(new Monster(game, 600, 245));
        monsters.add(new Monster(game, 900, 245));
        monsters.add(new Monster(game, 1200, 245));

        powerups = new LinkedList<>();
        powerups.add(new InitialPowerup(game, 0,0));
        powerups.add(new TypeA(game, powerups.get(0),450, 230));
        powerups.add(new TypeB(game, powerups.get(0),750, 230));
        powerups.add(new TypeD(game, player,1050, 225));
        powerups.add(new TypeC(game, powerups.get(0),1350, 230));

        messages = new MessageArea();

        collisionMonster = false;
        collisionPowerup = false;

        nextMonster = nextMonster();
        prevMonster = nextMonster;

        paused = false;
    }

    /**
     * This function adds a new monster and a new power up into game.
     */
    private void update(){
        int firstIndexMonster = 300;
        int firstIndexPowerup = 300;
        Random rand = new Random();
        int type = rand.nextInt(4);

        // for Monster
        for(int i=0; i < monsters.size(); i++){
            if(monsters.get(i).getX() <= -Monster.DEFAULT_WIDTH){
                monsters.remove(i);
                monsters.add(new Monster(game, 900 + firstIndexMonster, 245));
            }
        }

        // for Power up
        for(int i=1; i < powerups.size(); i++){
            if(powerups.get(i).getX() <= -Powerup.DEFAULT_WIDTH){
                powerups.remove(i);
                if(type == 0)
                    powerups.add(new TypeA(game, powerups.get(0), 900 + firstIndexPowerup, 230));
                else if(type == 1)
                    powerups.add(new TypeB(game, powerups.get(0), 900 + firstIndexPowerup, 230));
                else if(type == 2)
                    powerups.add(new TypeC(game, powerups.get(0), 900 + firstIndexPowerup, 230));
                else if(type == 3)
                    powerups.add(new TypeD(game, player, 900 + firstIndexPowerup, 225));
            }
        }

    }

    /**
     * This function updates every field and controls the collisions.
     * It also checks if the game is over.
     */
    @Override
    public void tick() {
        getInput();

       if(!paused) {
            player.tick();
            background.tick();
            bar.tick();
            for (Monster monster : monsters)
                monster.tick();
            for (Powerup powerup : powerups)
                powerup.tick();

            //controlling
            controlMonsterCollision();
            // control game over
            if (player.getLife() == 0)
                State.setState(new GameOverState(game));
            // end control
            controlSuccessfulJump();
            controlPowerupCollision();

            update();
        }
    }

    /**
     * This function gets the mouse inputs.
     */
    private void getInput(){
        if(game.getMouseManager().pause)
            paused = true;
        if(game.getMouseManager().resume)
            paused = false;
    }

    /**
     * This function draws the images and strings required in the game state.
     * @param g Graphics object is used to draw
     */
    @Override
    public void render(Graphics g) {
        background.render(g);
        player.render(g);
        bar.render(g);
        for (Monster monster : monsters)
            monster.render(g);
        for (Powerup powerup : powerups)
            powerup.render(g);
        messages.render(g);

        if(paused)
            g.drawImage(Assets.resumeButton, 325, 150, 50,50,null);
    }

    /**
     * This function checks whether the jump movement is successful.
     * If the player jumps successfully, the player earns points.
     */
    private void controlSuccessfulJump(){
        int x = player.getBounds().x - prevMonster.getWidth();

        if(nextMonster != nextMonster()){
            prevMonster = nextMonster;
            nextMonster = nextMonster();
        }
        if(prevMonster != null){
            if(prevMonster.getX() < x && !prevMonster.getCollision()){
                messages.addMessage("Successful Jump! Current points = " + player.getPoints() + ", earn " + player.getPowerFactor() + " points.");
                player.earnPoints();
                prevMonster.setCollision(true);
            }
        }
    }

    /**
     * This function checks whether the player collides with a monster.
     * If the player collides with a monster, the player loses a life.
     */
    private void controlMonsterCollision(){
        if(collisionMonster() && !collisionMonster) {
            collisionMonster = true;
            collisionMX = player.getX();
            player.loseLife();
            messages.addMessage("Collide Monster. Lose a life.");
        }
        if(collisionMonster){
            float waitTime = player.getX() - collisionMX;
            if(waitTime > Monster.DEFAULT_WIDTH + Player.DEFAULT_WIDTH)
                collisionMonster = false;
        }
    }

    /**
     * This function checks if the player collides with a monster.
     * @return true if they collide or false if they do not collide
     */
    private boolean collisionMonster (){
        for (int i=0; i < monsters.size(); i++){
            if(player.getBounds().intersects(monsters.get(i).getBounds())) {
                monsters.get(i).setCollision(true);
                return true;
            }
        }
        return false;
    }


    /**
     * This function checks whether the player collides with a power up.
     * If the player collides with a power up, the player acquired the power up and the player's power factor increases.
     */
    private void controlPowerupCollision(){
        int collideP = collisionPowerup();
        if(collideP != -1 && !collisionPowerup){
            collisionPowerup = true;
            collisionPX = player.getX();
            player.addPowerup(collideP);
        }
        if(collisionPowerup){
            float waitTime = player.getX() - collisionPX;
            if(waitTime > 77)
                collisionPowerup = false;
        }
    }

    /**
     * This function checks if the player collides with a powerup.
     * It returns the type of acquired powerup but it returns -1 if there is no collision.
     * @return the type of the acquired powerup
     */
    private int collisionPowerup (){
        for (int i=0; i < powerups.size(); i++){
            if(player.getBounds().intersects(powerups.get(i).getBounds())){
                powerups.get(i).setAcquired(true);
                return powerups.get(i).getType();
            }
        }
        return -1;
    }

    /**
     * This function finds the next monster according to player's position on the game
     * @return the next monster for the player
     */
    private Monster nextMonster(){
        for (Monster monster : monsters){
            if(monster.getX() > player.getFixedX())
                return monster;
        }
        return null;
    }
}
