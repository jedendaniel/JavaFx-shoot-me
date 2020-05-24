package dd.player;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Crosshair {
    private static final String IMAGE_URL = "shoot-me-client/src/main/resources/crosshair.png";
    private Image image;

    Crosshair() {
        try {
            image = new Image(new FileInputStream(IMAGE_URL));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return image;
    }
}
