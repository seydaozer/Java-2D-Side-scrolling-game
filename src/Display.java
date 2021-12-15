import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

/**
 * This class displays the game.
 */
public class Display {
    /**
     * the frame is used for the game.
     */
    private JFrame frame;
    /**
     * the canvas is used for the game.
     */
    private Canvas canvas;
    /**
     * this String is title of the game.
     */
    private String title;
    /**
     * this is width of the game window.
     */
    private int width;
    /**
     * this is height of the game window.
     */
    private int height;

    /**
     * Display Constructor
     * @param title title of the game
     * @param width width of the game window
     * @param height height of the game window
     */
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    /**
     * This function creates display window.
     */
    private void createDisplay(){
        // create a frame
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // create a canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        // add canvas to frame
        frame.add(canvas);
        frame.pack();
    }

    /**
     * Gets the canvas
     * @return the canvas
     */
    public Canvas getCanvas(){
        return canvas;
    }

    /**
     * Gets the frame
     * @return the frame
     */
    public JFrame getFrame(){
        return frame;
    }
}
