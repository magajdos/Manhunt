package manhunt.commands;

import manhunt.PlayersRole;
import manhunt.worldcreator.GameWorldTeleport;
import manhunt.worldcreator.ManHuntWorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.stream.Collectors;

public final class StopManHuntGame implements CommandExecutor {
    private final GameWorldTeleport teleport;
    private final ManHuntWorldCreator worldCreator;
    private final PlayersRole playersRole;

    public StopManHuntGame(GameWorldTeleport teleport, ManHuntWorldCreator worldCreator, PlayersRole playersRole) {
        this.teleport = teleport;
        this.worldCreator = worldCreator;
        this.playersRole = playersRole;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        teleport.teleportFromGame();
        try {
            worldCreator.removeWorld();
        } catch (IOException e) {
            commandSender.sendMessage("Unable to delete world directory.");
            throw new RuntimeException(e);
        }
        playersRole.reset();
        return true;
    }
}
