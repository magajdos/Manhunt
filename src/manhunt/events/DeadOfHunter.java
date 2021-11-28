package manhunt.events;

import manhunt.PlayersRole;
import manhunt.worldcreator.GameWorldTeleport;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DeadOfHunter implements Listener {
    private final PlayersRole playersRole;
    private final GameWorldTeleport teleport;

    public DeadOfHunter(PlayersRole playersRole, GameWorldTeleport teleport) {
        this.playersRole = playersRole;
        this.teleport = teleport;
    }

    @EventHandler
    public void deadOfHunter(PlayerDeathEvent event){
        if (playersRole.isHunter(event.getEntity())) {
            teleport.teleportToGame(event.getEntity());
            event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5, 20));
            event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 5, 20));
            event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, 20));
            event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 5, 20));
            event.getEntity().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 15, 1));
        }
    }
}
