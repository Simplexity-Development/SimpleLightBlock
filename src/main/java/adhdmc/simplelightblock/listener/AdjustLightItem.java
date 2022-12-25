package adhdmc.simplelightblock.listener;

import org.bukkit.Material;
import org.bukkit.block.data.type.Light;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockDataMeta;

public class AdjustLightItem implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL) return;
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (event.getMaterial() != Material.LIGHT) return;
        if (!event.getPlayer().isSneaking()) return;
        ItemStack itemStack = event.getItem();
        if (itemStack == null) return;
        event.setCancelled(true);
        BlockDataMeta data = (BlockDataMeta) itemStack.getItemMeta();
        Light light = (Light) data.getBlockData(Material.LIGHT);
        int level = light.getLevel();
        level += event.getAction().isRightClick() ? 1 : -1;
        if (level < 0) level = 15;
        if (level > 15) level = 0;
        light.setLevel(level);
        data.setBlockData(light);
        itemStack.setItemMeta(data);
    }

}
