package dd.input.commands;

import dd.player.Player;

public interface Command {
        void setPlayer(Player player);
        void execute();
}
