package dd.player;

import dd.geometry.Geometry;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Player {
    private static final int SPEED = 3;

    private Rectangle gameObject;
    private Crosshair crosshair;
    private Robot robot = new Robot();

    public Player(Geometry geometry, Color color) {
        gameObject = new Rectangle(10, 10, color);
        gameObject.setX(geometry.getX());
        gameObject.setY(geometry.getY());
        crosshair = new Crosshair();
    }

    public List<Node> getNodes() {
        return List.of(gameObject);
    }

    public Geometry getPosition() {
        return new Geometry((int)gameObject.getX(), (int)gameObject.getY());
    }

    public void move(Geometry movement) {
        gameObject.setX(gameObject.getX() + movement.getX() * SPEED);
        gameObject.setY(gameObject.getY() + movement.getY() * SPEED);
        robot.mouseMove(robot.getMousePosition().getX() + movement.getX() * SPEED,
                robot.getMousePosition().getY() + movement.getY() * SPEED);
    }

    public Crosshair getCrosshair() {
        return crosshair;
    }
}
