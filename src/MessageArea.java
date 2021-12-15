import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * This class represents the message window.
 * It includes the messages that are the information about player moves.
 */
public class MessageArea {
    /**
     * This is color of the String to be drawn
     */
    private Color color;
    /**
     * This is font of the String to be drawn
     */
    private Font font;
    /**
     * This is y-coordinate for the messages
     */
    private float y;
    /**
     * This is the list of the messages that are information about player moves.
     */
    private ArrayList<String> messages;

    /**
     * MessageArea Constructor
     */
    public MessageArea(){
        color = Color.BLACK;
        font = new Font("Arial", Font.PLAIN, 13);
        y = 380;
        messages = new ArrayList<>();
    }


    /**
     * This function add a new message into the list of the messages.
     * @param s new String to be added
     */
    public void addMessage(String s){
        if(messages.size() == 8) {
            messages.clear();
        }
        messages.add(s);
    }

    /**
     * This function draws messages.
     * @param g Graphics object is used to draw
     */
    public void render(Graphics g){
        g.setColor(color);
        g.setFont(font);

        for(int i = 0; i < messages.size(); i++){
            g.drawString(messages.get(i), 15, (int) (y + i * 15));
        }
    }

}
