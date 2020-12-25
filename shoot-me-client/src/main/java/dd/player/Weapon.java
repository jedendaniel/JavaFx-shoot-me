package dd.player;

import dd.geometry.Geometry;
import dd.object.GameObject;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static java.util.function.Predicate.not;

public class Weapon implements GameObject {

    private List<Bullet> bullets = new ArrayList<>();
    private List<GameObject> gameObjects = new ArrayList<>();
    private Rectangle graphic = new Rectangle(40,40, Color.GREEN);
    private boolean active = true;

    public void setPosition(Geometry geometry) {
        graphic.setX(geometry.getX());
        graphic.setY(geometry.getY());
    }

    @Override
    public void update() {
        bullets.stream().filter(GameObject::isActive).forEach(Bullet::update);
    }

    @Override
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    @Override
    public Node getNode() {
        return graphic;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean value) {
        this.active = value;
    }

    void shoot(Geometry geometry) {
        Bullet bullet = bullets.stream().filter(not(GameObject::isActive)).findFirst().orElse(getNewBullet());
        shootBullet(bullet, geometry);
    }

    private void shootBullet(Bullet bullet, Geometry geometry) {
        bullet.setPosition(geometry);
        bullet.setActive(true);
    }

    private Bullet getNewBullet() {
        Bullet bullet = new Bullet(BulletPrototype.TEST);
        bullets.add(bullet);
        gameObjects.addAll(bullet.getGameObjects());
        return bullet;
    }
}
