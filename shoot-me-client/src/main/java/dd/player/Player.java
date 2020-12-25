package dd.player;

import dd.geometry.Geometry;
import dd.object.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Character character;
    private List<GameObject> gameObjects = new ArrayList<>();

    public Player(Character character) {
        this.character = character;
        gameObjects.addAll(character.getGameObjects());
    }

    public void update() {
        character.update();
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void moveCharacter(Geometry geometry) {
        character.move(geometry);
    }

    public void shoot() {
        character.shoot();
    }

    public void onMouseMove(Geometry newMousePosition) {
        character.onMouseMove(newMousePosition);
    }
}
