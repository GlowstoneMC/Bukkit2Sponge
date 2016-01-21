package io.github.deathcap.bukkit2sponge.item;

import com.google.common.base.Optional;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.text.translation.Translation;

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
