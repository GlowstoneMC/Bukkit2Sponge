package io.github.deathcap.bukkit2sponge.block;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;

public class ShinyBlockSnapshot implements BlockSnapshot {

    private final BlockState state;

    public ShinyBlockSnapshot(BlockState state) {
        this.state = state;
    }

    public ShinyBlockSnapshot(org.bukkit.block.BlockState bukkitState) {
        ShinyBlockType type = new ShinyBlockType(bukkitState.getBlock().getType());
        ShinyBlockState state = new ShinyBlockState(type);
        this.state = state;
    }

    @Override
    public BlockState getState() {
        return state;
    }
}
