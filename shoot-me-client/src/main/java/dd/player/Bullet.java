package dd.player;

import dd.geometry.Geometry;
import dd.object.GameObject;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Bullet implements GameObject {

    private final BulletPrototype bulletPrototype;
    private Circle circle;
    private List<GameObject> gameObjects = new ArrayList<>();
    private Geometry position = new Geometry(0,0);
    private boolean active = true;

    Bullet(BulletPrototype bulletPrototype) {
        this.bulletPrototype = bulletPrototype;
        circle = new Circle(bulletPrototype.x, Color.RED);
        gameObjects.add(this);
    }

    void setPosition(Geometry position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    @Override
    public void update() {
        circle.setCenterX(position.getX());
        circle.setCenterY(position.getY());
    }

    @Override
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    @Override
    public Node getNode() {
        return circle;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean value) {
        this.active = value;
    }
}
