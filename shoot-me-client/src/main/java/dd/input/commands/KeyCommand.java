package dd.input.commands;

import javafx.scene.input.KeyCode;

public interface KeyCommand extends Command {
    KeyCode getDefaultKeyCode();
}
 