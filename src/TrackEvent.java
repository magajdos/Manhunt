import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

public class TrackEvent {
    public void track(PlayerInteractEvent event, Player speedRuner) {

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Player player = event.getPlayer();
            if (player.getInventory().getItemInMainHand().getType().equals(Material.COMPASS))
                if (player.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equals("[Right Click] to track")) {
                    ItemStack compas = (ItemStack) player.getInventory().getItemInMainHand();
                    CompassMeta itemMeta = (CompassMeta) compas.getItemMeta();
                    itemMeta.setLodestone(speedRuner.getLocation());
                    player.sendMessage("tracking...");
                }
        }
    }
}
