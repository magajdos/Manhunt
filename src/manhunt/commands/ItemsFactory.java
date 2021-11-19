package manhunt.commands;

import com.google.common.collect.Lists;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemsFactory {

    public void manHuntTeleporter(World world, Location location) {
        var teleporter = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
        teleporter.setVillagerType(Villager.Type.JUNGLE);
        teleporter.setProfession(Villager.Profession.ARMORER);
        ItemStack hat = new ItemStack(Material.DIAMOND_HELMET);
        var itemMeta = hat.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(0, "ManHuntTeleporter");
        itemMeta.setLore(lore);
        hat.setItemMeta(itemMeta);
        teleporter.setCustomName("Man Hunt".lines() + "[Right Click] to conect" + ChatColor.GOLD);
        teleporter.getEquipment().setHelmet(hat);
    }

    private List<String> kompassLore = Lists.newArrayList("[Right Click] to track");

    public boolean isTrackingKompass(ItemStack itemStack) {
        return itemStack.getItemMeta().getLore().get(0).equals(kompassLore.get(0)) &&
                itemStack.getType().equals(Material.COMPASS);
    }

    public ItemStack trackingKompas() {
        ItemStack kompas = new ItemStack(Material.COMPASS);
        kompas.addEnchantment(Enchantment.VANISHING_CURSE, 1);
        var itemMeta = kompas.getItemMeta();
        itemMeta.setLore(kompassLore);
        kompas.setItemMeta(itemMeta);
        return kompas;
    }
    public List<String> invisibleLore = Lists.newArrayList("10s Invisiblity coldown 60s", "Drink to use");
    public ItemStack invisibyliti() {
        ItemStack neviditelnost = new ItemStack(Material.POTION);
        PotionMeta itemMeta = (PotionMeta) neviditelnost.getItemMeta();
        itemMeta.setColor(Color.SILVER);
        itemMeta.setDisplayName("Invisiblity (10s)");
        itemMeta.setLore(invisibleLore);
        neviditelnost.setItemMeta(itemMeta);
        return neviditelnost;
    }

    public List<String> teleportLore = Lists.newArrayList("once per game teleport to random location", "Drink to use");
    public ItemStack teleport(){
        ItemStack teleport = new ItemStack(Material.POTION);
        PotionMeta itemMeta = (PotionMeta) teleport.getItemMeta();
        itemMeta.setColor(Color.PURPLE);
        itemMeta.setDisplayName("Teleport");
        itemMeta.setLore(teleportLore);
        teleport.setItemMeta(itemMeta);
        return teleport;
    }

    public List<String> crossbowLore = Lists.newArrayList("shoot deadly arrow 120s coldown", "Shoot to use");
    public ItemStack deadlyCrosbow(){
        ItemStack teleport = new ItemStack(Material.CROSSBOW);
        var itemMeta = teleport.getItemMeta();
        itemMeta.setDisplayName("Deadly Crosbow");
        itemMeta.setLore(crossbowLore);
        teleport.setItemMeta(itemMeta);
        return teleport;
    }

    public List<String> speedLore = Lists.newArrayList("super speed for 10s, 60s coldown", "Drink to use");
    public ItemStack superSpeed(){
        ItemStack teleport = new ItemStack(Material.POTION);
        PotionMeta itemMeta = (PotionMeta) teleport.getItemMeta();
        itemMeta.setColor(Color.YELLOW);
        itemMeta.setDisplayName("Super Speed (10s)");
        itemMeta.setLore(speedLore);
        teleport.setItemMeta(itemMeta);
        return teleport;
    }

}
