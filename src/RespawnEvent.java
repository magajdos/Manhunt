import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RespawnEvent implements Listener {
    public void respawn(PlayerRespawnEvent event, ItemStack kompas) {
        Player player = event.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,5,1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,5,1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,5,2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,5,1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,5,1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,10,5));
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,5,3));
        player.sendMessage(ChatColor.DARK_PURPLE +"RESPAWN");
        player.getInventory().addItem(kompas);
    }
}
