package dd;

import dd.config.Config;
import dd.geometry.Geometry;
import dd.input.InputHandler;
import dd.input.InputMapping;
import dd.player.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
    private Config config = Config.getInstance();
    private Group root = new Group();
    private Scene scene = new Scene(root, config.getScreenWidth(), config.getScreenHeight());
    private Player player = new Player(new Geometry(100, 100), Color.WHEAT);
    private InputHandler inputHandler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        setupScene(stage);
        setupPlayer();
        stage.show();

        final long frameStartTime = System.nanoTime();

        new AnimationTimer() {
            long lastTime = frameStartTime;

            public void handle(long currentNanoTime) {
                if (currentNanoTime - lastTime > config.getFrameSpeedRate()) {
                    inputHandler.handleFrameInput();
                    lastTime = currentNanoTime;
                }
            }
        }.start();
    }

    private void setupPlayer() {
        inputHandler = new InputHandler(new InputMapping(player), scene);
        root.getChildren().addAll(player.getNodes());
    }

    private void setupScene(Stage stage) {
        scene.setFill(Color.BLACK);
        scene.setCursor(new ImageCursor(player.getCrosshair().getImage()));
        stage.setTitle("Game");
        stage.setScene(scene);
    }

}
