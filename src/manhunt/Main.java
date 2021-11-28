package manhunt;

import com.google.common.collect.Sets;
import manhunt.commands.StartManHuntGame;
import manhunt.commands.StopManHuntGame;
import manhunt.events.AutoSmeltr;
import manhunt.events.DeadOfHunter;
import manhunt.events.DeathOfPrey;
import manhunt.events.TrackEvent;
import manhunt.worldcreator.GameWorldTeleport;
import manhunt.worldcreator.ManHuntWorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        var manHuntWorldCreator = new ManHuntWorldCreator(getServer());
        var playersRole = new PlayersRole(getServer());
        var gameWorldTeleporter = new GameWorldTeleport(getServer(), playersRole);

        getCommand("StartManHunt").setExecutor(new StartManHuntGame(manHuntWorldCreator, gameWorldTeleporter,playersRole));
        getCommand("StopManHunt").setExecutor(new StopManHuntGame(gameWorldTeleporter, manHuntWorldCreator,playersRole));
        getServer().getPluginManager().registerEvents(new TrackEvent(playersRole), this);
        getServer().getPluginManager().registerEvents(new AutoSmeltr(), this);
        getServer().getPluginManager().registerEvents(new DeathOfPrey(playersRole,gameWorldTeleporter,manHuntWorldCreator,getServer()), this);
        getServer().getPluginManager().registerEvents(new DeadOfHunter(playersRole,gameWorldTeleporter), this);

    }

}
