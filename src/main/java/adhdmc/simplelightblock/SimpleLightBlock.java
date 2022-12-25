package adhdmc.simplelightblock;

import adhdmc.simplelightblock.listener.AdjustLightItem;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleLightBlock extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new AdjustLightItem(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
