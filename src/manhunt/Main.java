package manhunt;

import com.google.common.collect.Sets;
import manhunt.commands.StartManHuntGame;
import manhunt.commands.StopManHuntGame;
import manhunt.worldcreator.GameWorldTeleport;
import manhunt.worldcreator.ManHuntWorldCreator;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

import javax.management.relation.Role;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        var manHuntWorldCreator = new ManHuntWorldCreator(getServer());
        var playersRole = new PlayersRole(Sets.newHashSet(getServer().getOnlinePlayers()));
        var gameWorldTeleporter = new GameWorldTeleport(getServer(), playersRole);

        getCommand("StartManHunt").setExecutor(new StartManHuntGame(manHuntWorldCreator, gameWorldTeleporter,playersRole));
        getCommand("StopManHunt").setExecutor(new StopManHuntGame(gameWorldTeleporter, manHuntWorldCreator));
        getServer().getPluginManager().registerEvents(new TrackEvent(playersRole), this);


    }

}
