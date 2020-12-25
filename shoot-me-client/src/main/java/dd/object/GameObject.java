package dd.object;

import javafx.scene.Node;

import java.util.List;

public interface GameObject {
    void update();
    List<GameObject> getGameObjects();
    Node getNode();
    boolean isActive();
    void setActive(boolean value);
}
