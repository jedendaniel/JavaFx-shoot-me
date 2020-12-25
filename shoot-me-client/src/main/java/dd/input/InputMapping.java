package dd.input;

import dd.input.commands.*;
import dd.player.Player;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class InputMapping {

    private static final List<KeyCommand> KEY_COMMANDS = List.of(
            new MoveUpKeyCommand(),
            new MoveDownKeyCommand(),
            new MoveLeftKeyCommand(),
            new MoveRightKeyCommand(),
            new ShootKeyCommand()
    );

    private static final List<MouseCommand> MOUSE_COMMANDS = List.of(
            new MouseMoveCommand()
    );

    private Map<KeyCode, KeyCommand> keyboardConfiguration;
    private Map<String, MouseCommand> mouseConfiguration;

    public InputMapping(Player player) {
        try {
            keyboardConfiguration = loadConfigurationFromFile();
        } catch (NotImplementedException e) {
            keyboardConfiguration = loadDefaultKeyBoardConfiguration(player);
            mouseConfiguration = loadMouseConfiguration(player);
        }
    }

    private Map<String, MouseCommand> loadMouseConfiguration(Player player) {
        return MOUSE_COMMANDS.stream()
                .peek(command -> command.setPlayer(player))
                .collect(Collectors.toMap(MouseCommand::getEventTypeName, Function.identity()));
    }

    private Map<KeyCode, KeyCommand> loadConfigurationFromFile() throws NotImplementedException {
        throw new NotImplementedException("Not implemented");
    }

    private Map<KeyCode, KeyCommand> loadDefaultKeyBoardConfiguration(Player player) {
        return KEY_COMMANDS.stream()
                .peek(command -> command.setPlayer(player))
                .collect(Collectors.toMap(KeyCommand::getDefaultKeyCode, Function.identity()));
    }

    public Optional<KeyCommand> getKeyCommand(KeyCode code) {
        return Optional.ofNullable(keyboardConfiguration.get(code));
    }

    public void changeConfiguration(KeyCode oldCode, KeyCode updatedCode) throws ConflictException {
        if (!keyboardConfiguration.containsKey(updatedCode) || oldCode == updatedCode) {
            keyboardConfiguration.put(updatedCode, keyboardConfiguration.get(oldCode));
        } else {
            throw new ConflictException(String.format("%s already occupied", updatedCode.getName()));
        }
    }

    public void saveConfigurationToFile() throws NotImplementedException {
        throw new NotImplementedException("Not implemented");
    }

    public Map<KeyCode, KeyCommand> getKeyboardConfiguration() {
        return keyboardConfiguration;
    }

    public Optional<MouseCommand> getMouseCommand(String name) {
        return Optional.ofNullable(mouseConfiguration.get(name));
    }
}
