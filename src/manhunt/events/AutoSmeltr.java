package manhunt.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class AutoSmeltr implements Listener {

    @EventHandler
    public void smelt(BlockBreakEvent event) {
        var drop = event.getBlock().getDrops();
        switch (event.getBlock().getType()) {
            case IRON_ORE:
                drop.clear();
                drop.add(new ItemStack(Material.IRON_INGOT,2));
                break;
            case GOLD_ORE:
                drop.clear();
                drop.add(new ItemStack(Material.GOLD_INGOT));
                break;
            case COPPER_ORE:
                drop.clear();
                drop.add(new ItemStack(Material.COPPER_INGOT,4));
                break;
        }
    }
}
