package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;

public class MouseMoveCommand implements MouseCommand {
    private Player player;

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String getEventTypeName() {
        return "MOUSE_MOVED";
    }

    @Override
    public void execute(Geometry newMousePosition) {
        player.onMouseMove(newMousePosition);
    }
}
