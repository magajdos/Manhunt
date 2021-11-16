package manhunt;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import java.util.List;

public class TrackEvent implements Listener {
    private final PlayersRole playersRole;

    public TrackEvent(PlayersRole playersRole) {
        this.playersRole = playersRole;
    }

    @EventHandler
    public void track(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Player player = event.getPlayer();
            if (player.getInventory().getItemInMainHand().getType().equals(Material.COMPASS))
                if (player.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equals("[Right Click] to track")) {
                    ItemStack compas = (ItemStack) player.getInventory().getItemInMainHand();
                    CompassMeta itemMeta = (CompassMeta) compas.getItemMeta();
                    List<Player> players = Lists.newArrayList(player.getServer().getOnlinePlayers());
                    itemMeta.setLodestone(playersRole.getPrey(players).get().getLocation());
                    player.sendMessage("tracking...");
                }
        }
    }
}
