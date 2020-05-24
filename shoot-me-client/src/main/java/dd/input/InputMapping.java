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

    private static final List<Command> allCommands = List.of(
            new MoveUpCommand(),
            new MoveDownCommand(),
            new MoveLeftCommand(),
            new MoveRightCommand()
    );

    private Map<KeyCode, Command> inputConfiguration;

    public InputMapping(Player player) {
        try {
            inputConfiguration = loadConfigurationFromFile();
        } catch (NotImplementedException e) {
            inputConfiguration = loadDefaultConfiguration(player);
        }
    }

    private Map<KeyCode, Command> loadConfigurationFromFile() throws NotImplementedException {
        throw new NotImplementedException("Not implemented");
    }

    private Map<KeyCode, Command> loadDefaultConfiguration(Player player) {
        return allCommands.stream()
                .peek(command -> command.setPlayer(player))
                .collect(Collectors.toMap(Command::getDefaultKeyCode, Function.identity()));
    }

    public Optional<Command> getCommand(KeyCode code) {
        return Optional.ofNullable(inputConfiguration.get(code));
    }

    public void changeConfiguration(KeyCode oldCode, KeyCode updatedCode) throws ConflictException {
        if (!inputConfiguration.containsKey(updatedCode) || oldCode == updatedCode) {
            inputConfiguration.put(updatedCode, inputConfiguration.get(oldCode));
        } else {
            throw new ConflictException(String.format("%s already occupied", updatedCode.getName()));
        }
    }

    public void saveConfigurationToFile() throws NotImplementedException {
        throw new NotImplementedException("Not implemented");
    }

    public Map<KeyCode, Command> getInputConfiguration() {
        return inputConfiguration;
    }
}
