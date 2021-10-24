import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Random;

public class AbilityListeners implements Listener {
    public void neviditelnost(PlayerInteractEvent event) {
        var player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10, 1, true, false, true));
        } else {
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10, 1, true, false, true));

            }
        }
    }

    public void teleport(PlayerInteractEvent event) {
        var player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            int random = new Random().nextInt(500);
            Location location = new Location(player.getWorld(), random, random, random);
            player.getLocation().getBlock().setType(Material.AIR);
            player.getLocation().add(0, 1, 0).getBlock().setType(Material.AIR);
            player.getLocation().add(0, -1, 0).getBlock().setType(Material.OBSIDIAN);
            player.teleport(location);


        } else {
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                int random = new Random().nextInt(500);
                Location location = new Location(player.getWorld(), random, random, random);
                player.getLocation().getBlock().setType(Material.AIR);
                player.getLocation().add(0, 1, 0).getBlock().setType(Material.AIR);
                player.getLocation().add(0, -1, 0).getBlock().setType(Material.OBSIDIAN);
                player.teleport(location);
            }


        }
    }

    public void deadlyCrossbow(PlayerInteractEvent event) {
        var player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {

        } else {
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            }
        }
    }

    public void deadlySuperSpeed(PlayerInteractEvent event) {
        var player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 10, 1));

        } else {
            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 10, 1));
            }
        }
    }

}