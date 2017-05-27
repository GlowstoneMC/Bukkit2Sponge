package net.glowstone.bukkit2sponge.event;

import org.spongepowered.api.event.block.BlockPlaceEvent;
import org.spongepowered.api.world.Location;

public class ShinyBlockPlaceEvent extends ShinyBlockEvent implements BlockPlaceEvent {
    public ShinyBlockPlaceEvent(Location block) {
        super(block);
    }

    public ShinyBlockPlaceEvent(org.bukkit.Location location, org.bukkit.block.BlockState replacement) {
        super(location, replacement);
    }
}
