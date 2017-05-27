package net.glowstone.bukkit2sponge.bukkit;

import net.glowstone.bukkit2sponge.Bukkit2Sponge;
import net.glowstone.bukkit2sponge.event.ShinyBlockBreakEvent;
import net.glowstone.bukkit2sponge.event.ShinyBlockPlaceEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BukkitListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent bukkitEvent) {
        Bukkit2Sponge.instance.getLogger().info("Bukkit BlockBreakEvent "+bukkitEvent);

        org.spongepowered.api.event.block.BlockBreakEvent spongeEvent = new ShinyBlockBreakEvent(bukkitEvent.getBlock().getLocation());
        Bukkit2Sponge.instance.getGame().getEventManager().post(spongeEvent);

        bukkitEvent.setCancelled(spongeEvent.isCancelled());
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent bukkitEvent) {
        Bukkit2Sponge.instance.getLogger().info("Bukkit BlockPlaceEvent "+bukkitEvent);

        org.spongepowered.api.event.block.BlockPlaceEvent spongeEvent = new ShinyBlockPlaceEvent(bukkitEvent.getBlock().getLocation(), bukkitEvent.getBlockReplacedState());
        Bukkit2Sponge.instance.getGame().getEventManager().post(spongeEvent);

        bukkitEvent.setCancelled(spongeEvent.isCancelled());
    }
}
