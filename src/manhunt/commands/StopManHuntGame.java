package manhunt.commands;

import manhunt.worldcreator.GameWorldTeleport;
import manhunt.worldcreator.ManHuntWorldCreator;
import org.bukkit.Server;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

public final class StopManHuntGame implements CommandExecutor {
    private final GameWorldTeleport teleport;
    private final ManHuntWorldCreator worldCreator;

    public StopManHuntGame(GameWorldTeleport teleport, ManHuntWorldCreator worldCreator) {
        this.teleport = teleport;
        this.worldCreator = worldCreator;
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
        return true;
    }
}
