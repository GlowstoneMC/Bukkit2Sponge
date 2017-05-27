package net.glowstone.bukkit2sponge.item;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.translation.Translation;

import java.util.Optional;

/**
 * Todo: Javadoc for ShinyItemType.
 */
public class ShinyItemType implements ItemType {

    private final String id;

    public ShinyItemType(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Optional<BlockType> getBlock() {
        return null;
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public int getMaxStackQuantity() {
        return 64;
    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getDefaultProperty(Class<T> propertyClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Translation getTranslation() {
        return null; //Text.of("item." + id + ".name").get(); // TODO
    }

    @Override
    public String toString() {
        return getTranslation().getId();
    }
}
