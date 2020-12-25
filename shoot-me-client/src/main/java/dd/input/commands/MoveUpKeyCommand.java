package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;
import javafx.scene.input.KeyCode;

public class MoveUpKeyCommand implements KeyCommand {

    private Player player;

    public MoveUpKeyCommand() {
    }

    public MoveUpKeyCommand(Player player) {
        this.player = player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public KeyCode getDefaultKeyCode() {
        return KeyCode.W;
    }

    @Override
    public void execute() {
        player.moveCharacter(Geometry.UP);
    }
}
