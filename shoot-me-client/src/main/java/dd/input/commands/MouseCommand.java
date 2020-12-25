package dd.input.commands;

import dd.geometry.Geometry;
import dd.player.Player;

public interface MouseCommand {
    void setPlayer(Player player);
    String getEventTypeName();
    void execute(Geometry newMousePosition);
}
