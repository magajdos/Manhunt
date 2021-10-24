import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TovarnaNaOstatni {
    public void ManHunt(World world, Location location) {
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

    public ItemStack TrackingKompas() {
        ItemStack kompas = new ItemStack(Material.COMPASS);
        kompas.addEnchantment(Enchantment.VANISHING_CURSE, 1);
        var itemMeta = kompas.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(0, "[Right Click] to track");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName(ChatColor.GOLD + "Tracking Kompas");
        kompas.setItemMeta(itemMeta);
        return kompas;
    }

    public ItemStack neviditelnost() {
        ItemStack neviditelnost = new ItemStack(Material.INK_SAC);
        var itemMeta = neviditelnost.getItemMeta();
        itemMeta.setDisplayName("Inviziblity (10s)");
        List<String>lore = new ArrayList<>();
        lore.add(0,"10s Inviziblity coldown 60s");
        lore.add(1,"[Right Click] to use");
        itemMeta.setLore(lore);
        neviditelnost.setItemMeta(itemMeta);
        return neviditelnost;
    }

    public ItemStack teleport(){
        ItemStack teleport = new ItemStack(Material.CHORUS_FRUIT);
        var itemMeta = teleport.getItemMeta();
        itemMeta.setDisplayName("Teleport");
        List<String>lore = new ArrayList<>();
        lore.add(0,"once per game teleport to random location");
        lore.add(1,"[Right Click] to use");
        itemMeta.setLore(lore);
        teleport.setItemMeta(itemMeta);
        return teleport;
    }
    public ItemStack deadlyCrosbow(){
        ItemStack teleport = new ItemStack(Material.BLAZE_ROD);
        var itemMeta = teleport.getItemMeta();
        itemMeta.setDisplayName("Neviditelnost (10s)");
        List<String>lore = new ArrayList<>();
        lore.add(0,"shoot deadly arrow 120s coldown");
        lore.add(1,"[Right Click] to use");
        itemMeta.setLore(lore);
        teleport.setItemMeta(itemMeta);
        return teleport;
    }
    public ItemStack superSpeed(){
        ItemStack teleport = new ItemStack(Material.SUGAR);
        var itemMeta = teleport.getItemMeta();
        itemMeta.setDisplayName("Super Speed (10s)");
        List<String>lore = new ArrayList<>();
        lore.add(0,"super speed for 10s, 60s coldown");
        lore.add(1,"[Right Click] to use");
        itemMeta.setLore(lore);
        teleport.setItemMeta(itemMeta);
        return teleport;
    }


}
