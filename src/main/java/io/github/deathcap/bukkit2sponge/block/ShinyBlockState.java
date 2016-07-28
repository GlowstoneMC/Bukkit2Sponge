package io.github.deathcap.bukkit2sponge.block;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.trait.BlockTrait;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.util.Cycleable;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

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
    public BlockState withExtendedProperties(Location<World> location) {
        return null;
    }

    @Override
    public BlockState cycleValue(Key<? extends BaseValue<? extends Cycleable<?>>> key) {
        return null;
    }

    @Override
    public BlockSnapshot snapshotFor(Location<World> location) {
        return null;
    }

    @Override
    public <T extends Comparable<T>> java.util.Optional<T> getTraitValue(BlockTrait<T> blockTrait) {
        return null;
    }

    @Override
    public java.util.Optional<BlockTrait<?>> getTrait(String s) {
        return null;
    }

    @Override
    public java.util.Optional<BlockState> withTrait(BlockTrait<?> blockTrait, Object o) {
        return null;
    }

    @Override
    public Collection<BlockTrait<?>> getTraits() {
        return null;
    }

    @Override
    public Collection<?> getTraitValues() {
        return null;
    }

    @Override
    public Map<BlockTrait<?>, ?> getTraitMap() {
        return null;
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

    @Override
    public int getContentVersion() {
        return 0;
    }

    @Override
    public DataContainer toContainer() {
        return null;
    }

    @Override
    public <T extends Property<?, ?>> java.util.Optional<T> getProperty(Direction direction, Class<T> aClass) {
        return null;
    }

    @Override
    public <T extends H> java.util.Optional<T> get(Class<T> aClass) {
        return null;
    }

    @Override
    public <T extends H> java.util.Optional<T> getOrCreate(Class<T> aClass) {
        return null;
    }

    @Override
    public boolean supports(Class<? extends ImmutableDataManipulator<?, ?>> aClass) {
        return false;
    }

    @Override
    public <E> java.util.Optional<BlockState> transform(Key<? extends BaseValue<E>> key, Function<E, E> function) {
        return null;
    }

    @Override
    public <E> java.util.Optional<BlockState> with(Key<? extends BaseValue<E>> key, E e) {
        return null;
    }

    @Override
    public java.util.Optional<BlockState> with(BaseValue<?> baseValue) {
        return null;
    }

    @Override
    public java.util.Optional<BlockState> with(ImmutableDataManipulator<?, ?> immutableDataManipulator) {
        return null;
    }

    @Override
    public java.util.Optional<BlockState> with(Iterable<ImmutableDataManipulator<?, ?>> iterable) {
        return null;
    }

    @Override
    public java.util.Optional<BlockState> without(Class<? extends ImmutableDataManipulator<?, ?>> aClass) {
        return null;
    }

    @Override
    public BlockState merge(BlockState blockState) {
        return null;
    }

    @Override
    public BlockState merge(BlockState blockState, MergeFunction mergeFunction) {
        return null;
    }

    @Override
    public List<ImmutableDataManipulator<?, ?>> getContainers() {
        return null;
    }

    @Override
    public <T extends Property<?, ?>> java.util.Optional<T> getProperty(Class<T> aClass) {
        return null;
    }

    @Override
    public Collection<Property<?, ?>> getApplicableProperties() {
        return null;
    }

    @Override
    public <E> java.util.Optional<E> get(Key<? extends BaseValue<E>> key) {
        return null;
    }

    @Override
    public <E, V extends BaseValue<E>> java.util.Optional<V> getValue(Key<V> key) {
        return null;
    }

    @Override
    public boolean supports(Key<?> key) {
        return false;
    }

    @Override
    public BlockState copy() {
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
