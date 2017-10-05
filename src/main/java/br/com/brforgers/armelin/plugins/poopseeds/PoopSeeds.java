package br.com.brforgers.armelin.plugins.poopseeds;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public final class PoopSeeds extends JavaPlugin {

    public static Plugin plugin;
    public static java.util.logging.Logger log;

    @Override
    public void onEnable() {
        config.options().copyDefaults(true);
        config.addDefault("PoopChance", 50);
        this.saveConfig();
        Bukkit.getPluginManager().registerEvents((Listener) new EvHandler(), (Plugin) this);
    }

    @Override
    public void onDisable() {
        log.info("Tchau!");
    }

    FileConfiguration config = this.getConfig();


    @Override
    public void onLoad(){
        plugin = this;
        log = this.getLogger();
        log.info("Armelin is topper!");
    }

}
