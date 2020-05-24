package dd.input;

import dd.input.commands.Command;
import dd.player.Player;
import javafx.scene.Scene;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InputHandler {

    private InputMapping inputMapping;
    private Set<Command> keysPressed = new HashSet<>();

    public InputHandler(InputMapping inputMapping, Scene scene) {
        this.inputMapping = inputMapping;
        scene.setOnKeyPressed(
                keyEvent -> {
                    Optional.ofNullable(inputMapping.getCommand(keyEvent.getCode()))
                            .map(Optional::get)
                            .ifPresent(keysPressed::add);
                }
        );
        scene.setOnKeyReleased(
                keyEvent -> {
                    Optional.ofNullable(inputMapping.getCommand(keyEvent.getCode()))
                            .map(Optional::get)
                            .ifPresent(keysPressed::remove);
                }
        );
    }

    public void handleFrameInput() {
        keysPressed.forEach(Command::execute);
    }
}
