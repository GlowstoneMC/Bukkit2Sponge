package io.github.deathcap.bukkit2sponge.bukkit;

import io.github.deathcap.bukkit2sponge.Bukkit2Sponge;
import io.github.deathcap.bukkit2sponge.event.ShinyBlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BukkitListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent bukkitEvent) {
        Bukkit2Sponge.instance.getLogger().info("Bukkit BlockBreakEvent "+bukkitEvent);

        org.spongepowered.api.event.block.BlockBreakEvent spongeEvent = new ShinyBlockBreakEvent(bukkitEvent.getBlock().getLocation());
        Bukkit2Sponge.instance.getGame().getEventManager().post(spongeEvent);

        bukkitEvent.setCancelled(spongeEvent.isCancelled());
    }
}
