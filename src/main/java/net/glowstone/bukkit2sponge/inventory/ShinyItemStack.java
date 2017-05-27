package net.glowstone.bukkit2sponge.inventory;

import org.spongepowered.api.data.*;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
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
    public boolean equalTo(ItemStack that) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public boolean validateRawData(DataView container) {
        return false;
    }

    @Override
    public void setRawData(DataView container) throws InvalidDataException {

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
    public <T extends Property<?, ?>> java.util.Optional<T> getProperty(Class<T> propertyClass) {
        return null;
    }

    @Override
    public Collection<Property<?, ?>> getApplicableProperties() {
        return null;
    }

    @Override
    public <T extends DataManipulator<?, ?>> java.util.Optional<T> get(Class<T> containerClass) {
        return null;
    }

    @Override
    public <T extends DataManipulator<?, ?>> java.util.Optional<T> getOrCreate(Class<T> containerClass) {
        return null;
    }

    @Override
    public boolean supports(Class<? extends DataManipulator<?, ?>> holderClass) {
        return false;
    }

    @Override
    public <E> DataTransactionResult offer(Key<? extends BaseValue<E>> key, E value) {
        return null;
    }

    @Override
    public <E> DataTransactionResult offer(Key<? extends BaseValue<E>> key, E value, Cause cause) {
        return null;
    }

    @Override
    public DataTransactionResult offer(DataManipulator<?, ?> valueContainer, MergeFunction function) {
        return null;
    }

    @Override
    public DataTransactionResult offer(DataManipulator<?, ?> valueContainer, MergeFunction function, Cause cause) {
        return null;
    }

    @Override
    public DataTransactionResult remove(Class<? extends DataManipulator<?, ?>> containerClass) {
        return null;
    }

    @Override
    public DataTransactionResult remove(Key<?> key) {
        return null;
    }

    @Override
    public DataTransactionResult undo(DataTransactionResult result) {
        return null;
    }

    @Override
    public DataTransactionResult copyFrom(DataHolder that, MergeFunction function) {
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
