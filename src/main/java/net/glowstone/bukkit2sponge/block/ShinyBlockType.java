package net.glowstone.bukkit2sponge.block;

import org.bukkit.Material;
import org.spongepowered.api.block.BlockSoundGroup;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.trait.BlockTrait;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.translation.Translation;

import java.util.Collection;
import java.util.Optional;

public class ShinyBlockType implements BlockType {

    private final String name;
    private final Material material;

    public ShinyBlockType(Material material) {
        this.material = material;
        this.name = material.toString();
    }

    @Override
    public String getId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BlockState getDefaultState() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<BlockState> getAllBlockStates() {
        return null;
    }

    @Override
    public Optional<ItemType> getItem() {
        return null;
    }

    @Override
    public boolean getTickRandomly() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTickRandomly(boolean tickRandomly) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<BlockTrait<?>> getTraits() {
        return null;
    }

    @Override
    public Optional<BlockTrait<?>> getTrait(String blockTrait) {
        return null;
    }

    @Override
    public BlockSoundGroup getSoundGroup() {
        return null;
    }

    @Override
    public Translation getTranslation() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(Class<T> propertyClass) {
        return null;
    }

    @Override
    public Collection<Property<?, ?>> getApplicableProperties() {
        return null;
    }
}
