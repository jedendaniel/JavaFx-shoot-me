package dd;

import dd.config.Config;
import dd.geometry.Geometry;
import dd.input.InputHandler;
import dd.input.InputMapping;
import dd.object.GameObject;
import dd.player.Character;
import dd.player.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {
    private final Group ROOT_GROUP = new Group();
    private final Config config = Config.getInstance();
    private final List<GameObject> gameObjects = new ArrayList<>();
    private final Scene scene = new Scene(ROOT_GROUP, config.getScreenWidth(), config.getScreenHeight());
    private final Player player = new Player(new Character(new Geometry(100, 100), Color.WHEAT));
    private InputHandler inputHandler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
//        test();
        setupScene(stage);
        setupPlayer();
        stage.show();

        final long frameStartTime = System.nanoTime();

        new AnimationTimer() {
            long lastTime = frameStartTime;

            public void handle(long currentNanoTime) {
                if (currentNanoTime - lastTime > config.getFrameSpeedRate()) {
                    inputHandler.handleFrameInput();
                    player.update();
                    updateGraphics();
                    lastTime = currentNanoTime;
                }
            }
        }.start();
    }

    private void test() {
        Rectangle rectangle1 = new Rectangle(20, 20, Color.GAINSBORO);
        Rectangle rectangle2 = new Rectangle(20, 20, Color.GAINSBORO);
        ROOT_GROUP.getChildren().add(rectangle1);
        ROOT_GROUP.getChildren().add(rectangle2);
        rectangle2.setX(40);
        System.out.println(ROOT_GROUP.getChildren().size());
        ROOT_GROUP.getChildren().setAll(List.of(rectangle1));
        System.out.println(ROOT_GROUP.getChildren().size());
    }

    private void setupPlayer() {
        inputHandler = new InputHandler(new InputMapping(player), scene);
        ROOT_GROUP.getChildren().addAll(getNodes(player.getGameObjects()));
    }

    private List<Node> getNodes(List<GameObject> gameObjects) {
        return gameObjects.stream().map(GameObject::getNode).collect(Collectors.toList());
    }

    private void setupScene(Stage stage) {
        scene.setFill(Color.BLACK);
        scene.setCursor(new ImageCursor(player.getCharacter().getCrosshair().getImage()));
        stage.setTitle("Game");
        stage.setScene(scene);
    }

    private void updateGraphics() {
        gameObjects.clear();
        List<GameObject> collect = player.getGameObjects().stream().filter(GameObject::isActive).collect(Collectors.toList());
//        System.out.println("Calculate, " + collect.size());
        gameObjects.addAll(collect);
        ROOT_GROUP.getChildren().setAll(getNodes(gameObjects));
    }
}
