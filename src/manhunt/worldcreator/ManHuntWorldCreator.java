package manhunt.worldcreator;

import org.bukkit.*;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.Random;

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

    public void removeWorld() throws IOException {
        var worldFolder = server.getWorld(ManHuntWorldCreator.WORLD_NAME).getWorldFolder();
        server.unloadWorld(ManHuntWorldCreator.WORLD_NAME,false);
        FileUtils.deleteDirectory(worldFolder);
    }
}
