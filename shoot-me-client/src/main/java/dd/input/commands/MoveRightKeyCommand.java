package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;
import javafx.scene.input.KeyCode;

public class MoveRightKeyCommand implements KeyCommand {

    private Player player;

    public MoveRightKeyCommand() {
    }

    public MoveRightKeyCommand(Player player) {
        this.player = player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public KeyCode getDefaultKeyCode() {
        return KeyCode.D;
    }

    @Override
    public void execute() {
        player.moveCharacter(Geometry.RIGHT);
    }
}
