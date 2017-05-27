package net.glowstone.bukkit2sponge.block;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.tileentity.TileEntityArchetype;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.*;
import java.util.function.Function;

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

    @Override
    public BlockState getExtendedState() {
        return null;
    }

    @Override
    public BlockSnapshot withState(BlockState blockState) {
        return null;
    }

    @Override
    public BlockSnapshot withContainer(DataContainer container) {
        return null;
    }

    @Override
    public boolean restore(boolean force, BlockChangeFlag flag) {
        return false;
    }

    @Override
    public Optional<UUID> getCreator() {
        return null;
    }

    @Override
    public Optional<UUID> getNotifier() {
        return null;
    }

    @Override
    public Optional<TileEntityArchetype> createArchetype() {
        return null;
    }

    @Override
    public UUID getWorldUniqueId() {
        return null;
    }

    @Override
    public Vector3i getPosition() {
        return null;
    }

    @Override
    public Optional<Location<World>> getLocation() {
        return null;
    }

    @Override
    public BlockSnapshot withLocation(Location<World> location) {
        return null;
    }

    @Override
    public List<ImmutableDataManipulator<?, ?>> getManipulators() {
        return null;
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

    @Override
    public DataContainer toContainer() {
        return null;
    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(Class<T> propertyClass) {
        return null;
    }

    @Override
    public Collection<Property<?, ?>> getApplicableProperties() {
        return null;
    }

    @Override
    public <T extends ImmutableDataManipulator<?, ?>> Optional<T> get(Class<T> containerClass) {
        return null;
    }

    @Override
    public <T extends ImmutableDataManipulator<?, ?>> Optional<T> getOrCreate(Class<T> containerClass) {
        return get(containerClass);
    }

    @Override
    public boolean supports(Class<? extends ImmutableDataManipulator<?, ?>> containerClass) {
        return false;
    }

    @Override
    public <E> Optional<BlockSnapshot> transform(Key<? extends BaseValue<E>> key, Function<E, E> function) {
        return null;
    }

    @Override
    public <E> Optional<BlockSnapshot> with(Key<? extends BaseValue<E>> key, E value) {
        return null;
    }

    @Override
    public Optional<BlockSnapshot> with(BaseValue<?> value) {
        return null;
    }

    @Override
    public Optional<BlockSnapshot> with(ImmutableDataManipulator<?, ?> valueContainer) {
        return null;
    }

    @Override
    public Optional<BlockSnapshot> with(Iterable<ImmutableDataManipulator<?, ?>> valueContainers) {
        return null;
    }

    @Override
    public Optional<BlockSnapshot> without(Class<? extends ImmutableDataManipulator<?, ?>> containerClass) {
        return null;
    }

    @Override
    public BlockSnapshot merge(BlockSnapshot that) {
        return null;
    }

    @Override
    public BlockSnapshot merge(BlockSnapshot that, MergeFunction function) {
        return null;
    }

    @Override
    public List<ImmutableDataManipulator<?, ?>> getContainers() {
        return null;
    }

    @Override
    public <E> Optional<E> get(Key<? extends BaseValue<E>> key) {
        return null;
    }

    @Override
    public <E, V extends BaseValue<E>> Optional<V> getValue(Key<V> key) {
        return null;
    }

    @Override
    public boolean supports(Key<?> key) {
        return false;
    }

    @Override
    public BlockSnapshot copy() {
        return null;
    }

    @Override
    public Set<Key<?>> getKeys() {
        return null;
    }

    @Override
    public Set<ImmutableValue<?>> getValues() {
        return null;
    }
}
