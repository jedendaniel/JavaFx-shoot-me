package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;
import javafx.scene.input.KeyCode;

public class MoveDownCommand implements Command {

    private Player player;

    public MoveDownCommand() {
    }

    public MoveDownCommand(Player player) {
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
        player.move(Geometry.DOWN);
    }
}
