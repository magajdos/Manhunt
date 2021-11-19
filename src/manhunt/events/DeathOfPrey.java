package manhunt.events;

import manhunt.PlayersRole;
import manhunt.worldcreator.GameWorldTeleport;
import manhunt.worldcreator.ManHuntWorldCreator;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DeathOfPrey implements Listener {

    private final PlayersRole playersRole;
    private final GameWorldTeleport teleport;
    private final ManHuntWorldCreator worldCreator;
    private final Server server;

    public DeathOfPrey(PlayersRole playersRole, GameWorldTeleport teleport, ManHuntWorldCreator worldCreator, Server server) {
        this.playersRole = playersRole;
        this.teleport = teleport;
        this.worldCreator = worldCreator;
        this.server = server;
    }

    @EventHandler
    public void prayDeath(PlayerDeathEvent event) {
        if (!(event.getEntity().equals(playersRole.getPrey()))) return;
        teleport.teleportFromGame();
        displayMessage();
        try {
            worldCreator.removeWorld();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        playersRole.reset();
    }

    private void displayMessage() {
        var players = server.getOnlinePlayers();
        var prey = playersRole.getPrey();
        prey.sendTitle(ChatColor.RED + "Game Over", ChatColor.DARK_RED + "You are Loser", 1, 3, 1);
        List<Player> hunters = players.stream()
                .filter(player -> player != prey)
                .collect(Collectors.toList());

        hunters.forEach(hunter -> hunter.sendTitle(ChatColor.RED + "Game Over", ChatColor.GOLD + "You are Winner", 1, 3, 1));
    }
}
