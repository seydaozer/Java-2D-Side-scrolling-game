import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * This class runs the game.
 */
public class Game implements Runnable {
    /**
     * This variable is false if the game has not started.
     * When the game starts, this variable becomes true.
     */
    private boolean running;
    /**
     * The game thread
     */
    private Thread thread;
    /**
     * It is used to display the game.
     */
    private Display display;
    /**
     * This is width of the game window.
     */
    private int width;
    /**
     * This is height of the game window.
     */
    private int height;
    /**
     * This String is title of the game.
     */
    public String title;
    /**
     * This is used to listen key inputs.
     */
    private KeyManager keyManager;
    /**
     * This is used to listen mouse inputs.
     */
    private MouseManager mouseManager;
    /**
     * This is the menu state for the game
     * It is initial state
     */
    private State menuState;
    /**
     * This is the buffer strategy of the game canvas.
     * Using this, the Graphics g is obtained for drawing on the canvas.
     * It shows the drawings.
     */
    private BufferStrategy bs;
    /**
     * This is used to draw on canvas.
     */
    private Graphics g; // paint brush
    /**
     * This is FPS value of the game.
     */
    private int FPS_value;

    /**
     * Game Constructor
     * @param title title of the game
     * @param width width value of the game window
     * @param height height value of the game window
     */
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        running = false;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        FPS_value = 0;
    }

    /**
     * This function initializes the game.
     */
    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        Assets.init();

        menuState = new MenuState(this);
        State.setState(menuState);
    }

    /**
     * This function gets the key inputs
     */
    private void tick(){
        keyManager.tick();

        if(State.getState() != null){
            State.getState().tick();
        }
    }

    /**
     * This function shows the drawings for the game.
     */
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0,0, width, height);
        // Draw Here!
        if(State.getState() != null){
            State.getState().render(g);
        }
        // End Drawing!
        bs.show();
        g.dispose();
    }

    /**
     * This function runs the game.
     */
    @Override
    public void run(){
        init();

        int fps = 50;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        // count FPS
        long timer = 0;
        int ticks = 0;
        //

        while(running){
            now = System.nanoTime(); // this is initialized at beginning
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            if(timer >= 1000000000) {
                FPS_value = ticks;
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    /**
     * This function starts the game.
     */
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * this function stops the game.
     */
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the key manager of the game
     * @return KeyManager object
     */
    public KeyManager getKeyManager(){
        return keyManager;
    }

    /**
     * Gets the mouse manager of the game
     * @return MouseManager object
     */
    public MouseManager getMouseManager() {
        return mouseManager;
    }

    /**
     * Gets the FPS value of the game
     * @return the current FPS value
     */
    public int getFPS_value() {
        return FPS_value;
    }

    /**
     * Gets the title of the game.
     * @return the game title
     */
    public String getTitle() {
        return title;
    }
}
