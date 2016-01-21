package io.github.deathcap.bukkit2sponge.inventory;

import com.google.common.base.Optional;
import org.spongepowered.api.data.*;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.text.translation.Translation;

import java.util.Collection;
import java.util.Set;

/**
 * Implementation of {@link ItemStack}.
 */
public class ShinyItemStack implements ItemStack {

    private final ItemType item;
    private int quantity;
    private short damage;

    private int maxQuantity;

    public ShinyItemStack(ItemType item) {
        this(item, 1, (short) 0);
    }

    public ShinyItemStack(ItemType item, int quantity) {
        this(item, quantity, (short) 0);
    }

    public ShinyItemStack(ItemType item, int quantity, short damage) {
        this.item = item;
        this.quantity = quantity;
        this.damage = damage;
        maxQuantity = item.getMaxStackQuantity();
    }

    @Override
    public ItemType getItem() {
        return item;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) throws IllegalArgumentException {
        if (quantity > maxQuantity) {
            throw new IllegalArgumentException("Quantity exceeds max: " + quantity + " > " + maxQuantity);
        }
        this.quantity = quantity;
    }

    @Override
    public int getMaxStackQuantity() {
        return maxQuantity;
    }

    @Override
    public ItemStackSnapshot createSnapshot() {
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
    public ItemStack copy() {
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

    @Override
    public <T extends DataManipulator<T>> Optional<T> getData(Class<T> tClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> Optional<T> getOrCreate(Class<T> tClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> boolean remove(Class<T> tClass) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> boolean isCompatible(Class<T> tClass) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> DataTransactionResult offer(T t) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> DataTransactionResult offer(T t, DataPriority dataPriority) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<? extends DataManipulator<?>> getManipulators() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(Class<T> tClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Property<?, ?>> getApplicableProperties() {
        return null;
    }

    @Override
    public Collection<Property<?, ?>> getProperties() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean validateRawData(DataContainer dataContainer) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRawData(DataContainer container) throws InvalidDataException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getContentVersion() {
        return 0;
    }

    @Override
    public DataContainer toContainer() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
    public boolean supports(Class<? extends DataManipulator<?, ?>> aClass) {
        return false;
    }

    @Override
    public <E> DataTransactionResult offer(Key<? extends BaseValue<E>> key, E e) {
        return null;
    }

    @Override
    public DataTransactionResult offer(DataManipulator<?, ?> dataManipulator, MergeFunction mergeFunction) {
        return null;
    }

    @Override
    public DataTransactionResult remove(Class<? extends DataManipulator<?, ?>> aClass) {
        return null;
    }

    @Override
    public DataTransactionResult remove(Key<?> key) {
        return null;
    }

    @Override
    public DataTransactionResult undo(DataTransactionResult dataTransactionResult) {
        return null;
    }

    @Override
    public DataTransactionResult copyFrom(DataHolder dataHolder, MergeFunction mergeFunction) {
        return null;
    }

    @Override
    public Collection<DataManipulator<?, ?>> getContainers() {
        return null;
    }

    @Override
    public Translation getTranslation() {
        return null;
    }
}
