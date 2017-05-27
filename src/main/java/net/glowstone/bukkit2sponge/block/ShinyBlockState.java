package net.glowstone.bukkit2sponge.block;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.DataManipulator;

public class ShinyBlockState implements BlockState {

    private final BlockType type;

    public ShinyBlockState(BlockType type) {
        this.type = type;
    }

    @Override
    public BlockType getType() {
        return this.type;
    }

    @Override
    public ImmutableCollection<DataManipulator<?>> getManipulators() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ImmutableCollection<String> getManipulatorIds() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<DataManipulator<?>> getManipulatorByName(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<? extends Comparable<?>> getManipulatorValue(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockState withData(DataManipulator<?> property) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockState cycleProperty(DataManipulator<?> property) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
