package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;
import javafx.scene.input.KeyCode;

public class MoveLeftKeyCommand implements KeyCommand {

    private Player player;

    public MoveLeftKeyCommand() {
    }

    public MoveLeftKeyCommand(Player player) {
        this.player = player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public KeyCode getDefaultKeyCode() {
        return KeyCode.A;
    }

    @Override
    public void execute() {
        player.moveCharacter(Geometry.LEFT);
    }
}
