package dd.input;

import dd.geometry.Geometry;
import dd.input.commands.Command;
import dd.input.commands.KeyCommand;
import javafx.scene.Scene;

import java.util.HashSet;
import java.util.Set;

public class InputHandler {

    private InputMapping inputMapping;
    private Set<KeyCommand> keysPressed = new HashSet<>();

    public InputHandler(InputMapping inputMapping, Scene scene) {
        this.inputMapping = inputMapping;
        scene.setOnKeyPressed(
                keyEvent -> {
                    this.inputMapping.getKeyCommand(keyEvent.getCode()).ifPresent(keysPressed::add);
                }
        );
        scene.setOnKeyReleased(
                keyEvent -> {
                    this.inputMapping.getKeyCommand(keyEvent.getCode()).ifPresent(keysPressed::remove);
                }
        );
        scene.setOnMouseMoved(
                mouseEvent -> {
                    this.inputMapping.getMouseCommand(mouseEvent.getEventType().getName())
                            .ifPresent(mouseCommand -> mouseCommand.execute(new Geometry(mouseEvent.getSceneX(), mouseEvent.getSceneY())));
                }
        );
    }

    public void handleFrameInput() {
        keysPressed.forEach(KeyCommand::execute);
    }
}
