package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;
import javafx.scene.input.KeyCode;

public class MoveRightCommand implements Command {

    private Player player;

    public MoveRightCommand() {
    }

    public MoveRightCommand(Player player) {
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
        player.move(Geometry.RIGHT);
    }
}
