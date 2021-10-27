package manhunt.worldcreator;

import org.bukkit.Server;
import org.bukkit.WorldBorder;
import org.bukkit.WorldCreator;

public class ManHuntWorldCreator {

    public static final String WORLD_NAME = "ManHuntWorld";

    private final Server server;

    public ManHuntWorldCreator(Server server) {
        this.server = server;
    }

    public String createWorld(int wordSize) {
        WorldCreator worldCreator = WorldCreator.name(WORLD_NAME);
        var world = server.createWorld(worldCreator);
        WorldBorder wb = world.getWorldBorder();
        wb.setCenter(0,0);
        wb.setSize(wordSize);
        return world.getName();
    }
}
