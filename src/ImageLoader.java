import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * This class loads images into my game.
 */
public class ImageLoader {
    /**
     * This function takes a path and load the image on the path.
     * @param path the path of the image to be load
     * @return uploaded game
     */
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
