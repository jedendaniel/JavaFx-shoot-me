package dd.player;

import dd.geometry.Geometry;
import dd.object.GameObject;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Character implements GameObject {

    private static final int SPEED = 3;
    private Rectangle rectangle;
    private Crosshair crosshair;
    private Geometry position;
    private Weapon weapon = new Weapon();
    private List<GameObject> gameObjects = new ArrayList<>();
    private boolean active = true;

    public Character(Geometry position, Color color) {
        this.position = position;
        rectangle = new Rectangle(40, 40, color);
        crosshair = new Crosshair();
        gameObjects.add(this);
        gameObjects.add(weapon);
        gameObjects.addAll(weapon.getGameObjects());
    }

    @Override
    public void update() {
        rectangle.setX(position.getX());
        rectangle.setY(position.getY());
        weapon.update();
    }

    private Geometry getWeaponPosition(Geometry mousePosition) {
        Geometry difference = mousePosition.subtract(position);
        System.out.println("Character41 difference = " + difference);
        double x = 20 * (difference.getX() / (Math.abs(difference.getX()) + Math.abs(difference.getY())));
        double y = 20 * (difference.getY() / (Math.abs(difference.getX()) + Math.abs(difference.getY())));
        Geometry g = new Geometry(x, y);
        System.out.println("Character44 g = " + g.toString());
        return new Geometry(position.getX() + x, position.getY() + y);
    }

    @Override
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    @Override
    public Node getNode() {
        return rectangle;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean value) {
        this.active = value;
    }

    public Crosshair getCrosshair() {
        return crosshair;
    }

    void move(Geometry movement) {
        position.setX(position.getX() + movement.getX() * SPEED);
        position.setY(position.getY() + movement.getY() * SPEED);
        crosshair.move(movement, SPEED);
    }

    void shoot() {
        weapon.shoot(position);
    }

    public void onMouseMove(Geometry newMousePosition) {
        weapon.setPosition(getWeaponPosition(newMousePosition));
    }
}
