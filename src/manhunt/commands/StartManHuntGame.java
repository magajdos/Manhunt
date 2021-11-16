package manhunt.commands;

import com.google.common.collect.Sets;
import manhunt.PlayersRole;
import manhunt.exceptions.UserException;
import manhunt.worldcreator.GameWorldTeleport;
import manhunt.worldcreator.ManHuntWorldCreator;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public final class StartManHuntGame implements CommandExecutor {

    private final ManHuntWorldCreator manHuntWorldCreator;
    private final GameWorldTeleport teleport;
    private final PlayersRole playersRole;

    public StartManHuntGame(ManHuntWorldCreator manHuntWorldCreator, GameWorldTeleport teleport, PlayersRole playersRole) {
        this.manHuntWorldCreator = manHuntWorldCreator;
        this.teleport = teleport;
        this.playersRole = playersRole;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //prvni parametr je velikost sveta
        try {
            if (strings.length > 2) {
                throw new UserException("Command musi mit 2 parametry, velikost sveta a jmeno koristi.");
            }
            //svet
            var velikostSveta = Integer.parseInt(strings[0]);
            if (velikostSveta > 1500) throw new UserException("Svet nesmi byt vetsi nez 1500");
            //korist
            var jmenoKoristi = strings[1];
            playersRole.setPrey(jmenoKoristi);

            var jmenoSveta = manHuntWorldCreator.createWorld(velikostSveta);
            teleport.teleportToGame();
        } catch (NumberFormatException e) {
            throw new UserException("Velikost sveta (parameter 1) musi byt cislo.");
        }
        return true;
    }
}
