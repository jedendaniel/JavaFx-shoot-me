package dd.player;

import dd.geometry.Geometry;
import javafx.scene.image.Image;
import javafx.scene.robot.Robot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class Crosshair {
    private static final String IMAGE_URL = "shoot-me-client/src/main/resources/crosshair.png";
    private Image image;
    private Robot robot = new Robot();

    Crosshair() {
        try {
            image = new Image(new FileInputStream(IMAGE_URL));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void move(Geometry movement, int speed) {
        robot.mouseMove(robot.getMousePosition().getX() + movement.getX() * speed,
                robot.getMousePosition().getY() + movement.getY() * speed);
    }

    public Image getImage() {
        return image;
    }

    public Geometry getPosition() {
        return new Geometry((int)robot.getMouseX(), (int)robot.getMouseY());
    }
}
