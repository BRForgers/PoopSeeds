package br.com.brforgers.armelin.plugins.poopseeds;

import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EvHandler implements Listener {

    Material[] seeds = new Material[]{Material.SEEDS, Material.BEETROOT_SEEDS, Material.MELON_SEEDS, Material.PUMPKIN_SEEDS, Material.COCOA};
    Random r = new Random();


    @EventHandler
    public void onSheepRegrowWool(SheepRegrowWoolEvent event) {
        Sheep sheep = event.getEntity();
        if(r.nextInt(100) < PoopSeeds.plugin.getConfig().getInt("PoopChance")){
            sheep.getWorld().dropItemNaturally(sheep.getLocation(), new ItemStack(seeds[r.nextInt(seeds.length)],1));
        }
    }
}
