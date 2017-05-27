package net.glowstone.bukkit2sponge.bukkit;

import net.glowstone.bukkit2sponge.Bukkit2Sponge;
import net.glowstone.bukkit2sponge.event.ShinyBlockBreakEvent;
import net.glowstone.bukkit2sponge.event.ShinyBlockPlaceEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;

import java.util.List;

public class BukkitListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent bukkitEvent) {
        Bukkit2Sponge.instance.getLogger().info("Bukkit BlockBreakEvent "+bukkitEvent);

        org.spongepowered.api.event.block.ChangeBlockEvent.Break spongeEvent = new org.spongepowered.api.event.block.ChangeBlockEvent.Break() {
            @Override
            public Cause getCause() {
                return Cause.of(NamedCause.PLAYER_BREAK);
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public void setCancelled(boolean cancel) {

            }

            @Override
            public List<Transaction<BlockSnapshot>> getTransactions() {
                return null;
            }
        }
        Bukkit2Sponge.instance.getGame().getEventManager().post(spongeEvent);

        bukkitEvent.setCancelled(spongeEvent.isCancelled());
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent bukkitEvent) {
        Bukkit2Sponge.instance.getLogger().info("Bukkit BlockPlaceEvent "+bukkitEvent);

        org.spongepowered.api.event.block.ChangeBlockEvent.Place spongeEvent = new ShinyBlockPlaceEvent(bukkitEvent.getBlock().getLocation(), bukkitEvent.getBlockReplacedState());
        Bukkit2Sponge.instance.getGame().getEventManager().post(spongeEvent);

        bukkitEvent.setCancelled(spongeEvent.isCancelled());
    }
}
