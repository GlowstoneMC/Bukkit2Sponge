package io.github.deathcap.bukkit2sponge.block;

import com.google.common.base.Optional;
import org.bukkit.Material;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.ItemBlock;
import org.spongepowered.api.text.translation.Translation;

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
    public boolean getTickRandomly() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTickRandomly(boolean tickRandomly) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isLiquid() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isSolidCube() {
        return this.material.isOccluding();
    }

    @Override
    public boolean isGaseous() {
        return this.material == Material.AIR;
    }

    @Override
    public boolean isAffectedByGravity() {
        return this.material.hasGravity();
    }

    @Override
    public boolean areStatisticsEnabled() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public float getEmittedLight() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<ItemBlock> getHeldItem() {
        return Optional.absent();
    }

    @Override
    public Translation getTranslation() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
