import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerBucketEntityEvent;

public class ConectEvent implements Listener {

    public void conectCLICK(PlayerBucketEntityEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType().equals(EntityType.VILLAGER)) {
            Villager villager = (Villager) entity;

            var equipment = villager.getEquipment();
            if (!(equipment.getHelmet() == null)) {
                var lore = villager.getEquipment().getHelmet().getItemMeta().getLore();
                if (lore.get(0).equals("ManHuntTeleporter")) {
//                    pridani hrace do ListHracuVLoby

                    event.getPlayer().sendMessage("Byl jsi úspěšně připojen do hry");
                    event.setCancelled(true);
                }
            }
        }
    }

    public void conectHIT(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType().equals(EntityType.VILLAGER)) {
            Villager villager = (Villager) entity;

            var equipment = villager.getEquipment();
            if (!(equipment.getHelmet() == null)) {
                var lore = villager.getEquipment().getHelmet().getItemMeta().getLore();
                if (lore.get(0).equals("ManHuntTeleporter")) {
//                    pridani hrace do ListHracuVLoby
//                    teleportovani do hry
                    event.getDamager().sendMessage("Byl jsi úspěšně připojen do arény");
                    event.setCancelled(true);
                }
            }
        }
    }
}
