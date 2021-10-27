package manhunt.commands;

import manhunt.exceptions.UserException;
import manhunt.worldcreator.ManHuntWorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartManHuntGame implements CommandExecutor {

    private final ManHuntWorldCreator manHuntWorldCreator;

    StartManHuntGame(ManHuntWorldCreator manHuntWorldCreator) {
        this.manHuntWorldCreator = manHuntWorldCreator;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //prvni parametr je velikost sveta
        try {
            var velikostSveta = Integer.parseInt(strings[0]);
            if (velikostSveta > 1500) throw new UserException("Svet nesmi byt vetsi nez 1500");

            var jmenoSveta = manHuntWorldCreator.createWorld(velikostSveta);
        } catch (NumberFormatException e) {
            throw new UserException("Velikost sveta (parameter 1) musi byt cislo.");
        }
        return true;
    }
}
