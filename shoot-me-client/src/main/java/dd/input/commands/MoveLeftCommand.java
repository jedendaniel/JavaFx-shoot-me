package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;
import javafx.scene.input.KeyCode;

public class MoveLeftCommand implements Command {

    private Player player;

    public MoveLeftCommand() {
    }

    public MoveLeftCommand(Player player) {
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
        player.move(Geometry.LEFT);
    }
}
