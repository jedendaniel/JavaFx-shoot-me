package dd.input.commands;

import dd.player.Player;
import javafx.scene.input.KeyCode;

public interface Command {
    void setPlayer(Player player);
    KeyCode getDefaultKeyCode();
    void execute();
}
 