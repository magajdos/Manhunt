import org.bukkit.Server;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnderDragonKill implements Listener {

    public void dragonKill(EntityDeathEvent event, Server server) {

        server.createWorld(WorldCreator.name("ManHuntWorld"));
        server.unloadWorld("ManHuntWorld",true);

        if (event.getEntity().equals(EntityType.ENDER_DRAGON)) {
            server.broadcastMessage("SpeedRuner Winn the Game");

        }
    }
}
