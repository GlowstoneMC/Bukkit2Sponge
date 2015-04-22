package io.github.deathcap.bukkit2sponge.event;

import io.github.deathcap.bukkit2sponge.block.ShinyBlockSnapshot;
import io.github.deathcap.bukkit2sponge.world.ShinyWorld;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.event.ExperienceEvent;
import org.spongepowered.api.event.block.BlockChangeEvent;
import org.spongepowered.api.event.block.BlockEvent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

public class ShinyBlockEvent extends ShinyGameEvent implements BlockEvent, BlockChangeEvent, ExperienceEvent {

    private Location block;
    private int exp;
    private BlockSnapshot replacement;

    public ShinyBlockEvent(Location block) {
        this.block = block;
    }

    public ShinyBlockEvent(org.bukkit.Location location) {
        this(location, null);
    }

    public ShinyBlockEvent(org.bukkit.Location location, org.bukkit.block.BlockState replacement) {
        Extent extent = new ShinyWorld(location.getWorld());
        this.block = new Location(extent, location.getX(), location.getY(), location.getZ());

        if (replacement != null) {
            this.replacement = new ShinyBlockSnapshot(replacement);
        }
    }



    public Location getBlock() {
        return this.block;
    }

    @Override
    public BlockSnapshot getReplacementBlock() {
        return this.replacement;
    }

    @Override
    public int getExp() {
        return this.exp;
    }

    @Override
    public void setExp(int exp) {
        this.exp = exp;
    }
}
