package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;
import javafx.scene.input.KeyCode;

public class MoveDownKeyCommand implements KeyCommand {

    private Player player;

    public MoveDownKeyCommand() {
    }

    public MoveDownKeyCommand(Player player) {
        this.player = player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public KeyCode getDefaultKeyCode() {
        return KeyCode.S;
    }

    @Override
    public void execute() {
        player.moveCharacter(Geometry.DOWN);
    }
}
