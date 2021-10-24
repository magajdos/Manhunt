import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class AutoSmeltr implements Listener {
    public void smelt(BlockBreakEvent event) {


        if (event.getBlock().getType().equals(Material.IRON_ORE)) {
            var drop = event.getBlock().getDrops();
            drop.clear();
            drop.add(new ItemStack(Material.IRON_INGOT));
        } else {
            if (event.getBlock().getType().equals(Material.GOLD_ORE)) {
                var drop = event.getBlock().getDrops();
                drop.clear();
                drop.add(new ItemStack(Material.GOLD_INGOT));
            } else {
                if (event.getBlock().getType().equals(Material.COPPER_ORE)) {
                    var drop = event.getBlock().getDrops();
                    drop.clear();
                    drop.add(new ItemStack(Material.COPPER_INGOT));
                }
            }
        }
    }
}
