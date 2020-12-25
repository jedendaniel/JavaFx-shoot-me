package dd.input.commands;

import dd.player.Player;
import javafx.scene.input.KeyCode;

public class ShootKeyCommand implements KeyCommand {

    private Player player;

    public ShootKeyCommand() {
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public KeyCode getDefaultKeyCode() {
        return KeyCode.SPACE;
    }

    @Override
    public void execute() {
        player.shoot();
        System.out.println("Careful, player is shooting!");
    }
}
