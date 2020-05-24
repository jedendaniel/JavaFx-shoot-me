package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;
import javafx.scene.input.KeyCode;

public class MoveUpCommand implements Command {

    private Player player;

    public MoveUpCommand() {
    }

    public MoveUpCommand(Player player) {
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
        player.move(Geometry.UP);
    }
}
