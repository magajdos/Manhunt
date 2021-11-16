package manhunt.worldcreator;

import com.google.common.collect.Maps;
import manhunt.PlayersRole;
import manhunt.TovarnaNaOstatni;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public final class GameWorldTeleport {

    private final Server server;
    private PlayersRole playersRole;
    //jmeno hrace: pozice
    private final Map<String, Location> playersPositionInHomeWorld = new HashMap<>();
    public GameWorldTeleport(Server server, PlayersRole playersRole) {
        this.playersRole = playersRole;
        this.server = server;
    }

    public void teleportToGame() {
        World gameWorld = server.getWorld(ManHuntWorldCreator.WORLD_NAME);
        int i = 0;
        for (Player player : server.getOnlinePlayers()) {
            playersPositionInHomeWorld.put(player.getName(), player.getLocation());
            if (playersRole.isPrey(player)) {
                //korist bude dale od hunteru
                player.teleport(findSurface(new Location(gameWorld,i++ ,0,15)));
            } else {
                player.teleport(findSurface(new Location(gameWorld,i++ ,0,0)));
                player.getInventory().addItem(TovarnaNaOstatni.TrackingKompas());
            }
        }
    }

    public void teleportFromGame() {
        for (Player player : server.getOnlinePlayers()){
            Location positionInHomeWorld = playersPositionInHomeWorld.get(player.getName());
            player.teleport(positionInHomeWorld);
        }
    }

    private Location findSurface(Location location) {
        location.setY(250);
        while (true) {
            if (location.getBlock().getType() != Material.AIR) {
                return location.add(0, 1, 0);
            }
            location = location.add(0,-1,0);
        }
    }
}
