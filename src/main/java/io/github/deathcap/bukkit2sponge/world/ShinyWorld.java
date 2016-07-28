package io.github.deathcap.bukkit2sponge.world;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.ScheduledBlockUpdate;
import org.spongepowered.api.block.tile.TileEntity;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.*;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.DiscreteTransform2;
import org.spongepowered.api.util.DiscreteTransform3;
import org.spongepowered.api.util.persistence.InvalidDataException;
import org.spongepowered.api.world.*;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.difficulty.Difficulties;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.extent.*;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.storage.WorldStorage;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.Weathers;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ShinyWorld implements World {
    private org.bukkit.World handle;

    public ShinyWorld(org.bukkit.World handle) {
        this.handle = handle;
    }

    public org.bukkit.World getHandle() {
        return this.handle;
    }

    @Override
    public Difficulty getDifficulty() {
        switch (this.handle.getDifficulty()) {
            case EASY: return Difficulties.EASY;
            case HARD: return Difficulties.HARD;
            case NORMAL: return Difficulties.NORMAL;
            case PEACEFUL: return Difficulties.PEACEFUL;
            default: return Difficulties.NORMAL;
        }
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isLoaded() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Extent getExtentView(Vector3i vector3i, Vector3i vector3i1) {
        return null;
    }

    @Override
    public Extent getExtentView(DiscreteTransform3 discreteTransform3) {
        return null;
    }

    @Override
    public Extent getRelativeExtentView() {
        return null;
    }

    @Override
    public Optional<Chunk> getChunk(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public java.util.Optional<Chunk> getChunk(int i, int i1, int i2) {
        return null;
    }

    @Override
    public Optional<Chunk> loadChunk(Vector3i position, boolean shouldGenerate) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public java.util.Optional<Chunk> loadChunk(int i, int i1, int i2, boolean b) {
        return null;
    }

    @Override
    public boolean unloadChunk(Chunk chunk) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterable<Chunk> getLoadedChunks() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<Entity> getEntity(UUID uuid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WorldBorder getWorldBorder() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WorldBorder.ChunkPreGenerate newChunkPreGenerate(Vector3d vector3d, double v) {
        return null;
    }

    @Override
    public Optional<String> getGameRule(String gameRule) {
        return Optional.of(this.handle.getGameRuleValue(gameRule));
    }

    @Override
    public Map<String, String> getGameRules() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Dimension getDimension() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WorldGenerator getWorldGenerator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setWorldGenerator(WorldGenerator generator) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean doesKeepSpawnLoaded() {
        return this.handle.getKeepSpawnInMemory();
    }

    @Override
    public void setKeepSpawnLoaded(boolean keepLoaded) {
        this.handle.setKeepSpawnInMemory(keepLoaded);
    }

    @Override
    public WorldStorage getWorldStorage() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Scoreboard getScoreboard() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WorldCreationSettings getCreationSettings() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WorldProperties getProperties() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Location getSpawnLocation() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void triggerExplosion(Explosion explosion) {

    }

    @Override
    public TeleporterAgent getTeleporterAgent() {
        return null;
    }

    @Override
    public int getHeight() {
        return this.handle.getMaxHeight();
    }

    @Override
    public int getBuildHeight() {
        return this.handle.getMaxHeight(); // TODO: same?
    }

    @Override
    public Context getContext() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(Location location) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Location getFullBlock(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Location getFullBlock(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockType getBlockType(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockType getBlockType(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UnmodifiableBlockVolume getUnmodifiableBlockView() {
        return null;
    }

    @Override
    public MutableBlockVolume getBlockCopy() {
        return null;
    }

    @Override
    public MutableBlockVolume getBlockCopy(StorageType storageType) {
        return null;
    }

    @Override
    public ImmutableBlockVolume getImmutableBlockCopy() {
        return null;
    }

    @Override
    public void setBlockType(Vector3i position, BlockType type) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBlockType(int x, int y, int z, BlockType type) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MutableBlockVolume getBlockView(Vector3i vector3i, Vector3i vector3i1) {
        return null;
    }

    @Override
    public MutableBlockVolume getBlockView(DiscreteTransform3 discreteTransform3) {
        return null;
    }

    @Override
    public MutableBlockVolume getRelativeBlockView() {
        return null;
    }

    @Override
    public BlockSnapshot getBlockSnapshot(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockSnapshot getBlockSnapshot(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBlockSnapshot(Vector3i position, BlockSnapshot snapshot) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBlockSnapshot(int x, int y, int z, BlockSnapshot snapshot) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> Optional<T> getBlockData(Vector3i position, Class<T> dataClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> Optional<T> getBlockData(int x, int y, int z, Class<T> dataClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void interactBlock(Vector3i position) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void interactBlock(int x, int y, int z) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void interactBlockWith(Vector3i position, ItemStack itemStack) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void interactBlockWith(int x, int y, int z, ItemStack itemStack) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean digBlock(Vector3i position) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean digBlock(int x, int y, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean digBlockWith(Vector3i position, ItemStack itemStack) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean digBlockWith(int x, int y, int z, ItemStack itemStack) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockDigTime(Vector3i position) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockDigTime(int x, int y, int z) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockDigTimeWith(Vector3i position, ItemStack itemStack) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockDigTimeWith(int x, int y, int z, ItemStack itemStack) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLuminance(Vector3i position) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLuminance(int x, int y, int z) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLuminanceFromSky(Vector3i position) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLuminanceFromSky(int x, int y, int z) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLuminanceFromGround(Vector3i position) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte getLuminanceFromGround(int x, int y, int z) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockPowered(Vector3i position) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockPowered(int x, int y, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockIndirectlyPowered(Vector3i position) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockIndirectlyPowered(int x, int y, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockFacePowered(Vector3i position, Direction direction) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockFacePowered(int x, int y, int z, Direction direction) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(Vector3i position, Direction direction) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(int x, int y, int z, Direction direction) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Direction> getPoweredBlockFaces(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Direction> getPoweredBlockFaces(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Direction> getIndirectlyPoweredBlockFaces(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Direction> getIndirectlyPoweredBlockFaces(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockPassable(Vector3i position) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockPassable(int x, int y, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockFlammable(Vector3i position, Direction faceDirection) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isBlockFlammable(int x, int y, int z, Direction faceDirection) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBlock(Vector3i vector3i, BlockState blockState, boolean b) {

    }

    @Override
    public void setBlock(int i, int i1, int i2, BlockState blockState, boolean b) {

    }

    @Override
    public void setBlockType(Vector3i vector3i, BlockType blockType, boolean b) {

    }

    @Override
    public void setBlockType(int i, int i1, int i2, BlockType blockType, boolean b) {

    }

    @Override
    public BlockSnapshot createSnapshot(Vector3i vector3i) {
        return null;
    }

    @Override
    public BlockSnapshot createSnapshot(int i, int i1, int i2) {
        return null;
    }

    @Override
    public boolean restoreSnapshot(BlockSnapshot blockSnapshot, boolean b, boolean b1) {
        return false;
    }

    @Override
    public boolean restoreSnapshot(Vector3i vector3i, BlockSnapshot blockSnapshot, boolean b, boolean b1) {
        return false;
    }

    @Override
    public boolean restoreSnapshot(int i, int i1, int i2, BlockSnapshot blockSnapshot, boolean b, boolean b1) {
        return false;
    }

    @Override
    public Collection<ScheduledBlockUpdate> getScheduledUpdates(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<ScheduledBlockUpdate> getScheduledUpdates(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ScheduledBlockUpdate addScheduledUpdate(Vector3i position, int priority, int ticks) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ScheduledBlockUpdate addScheduledUpdate(int x, int y, int z, int priority, int ticks) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeScheduledUpdate(Vector3i position, ScheduledBlockUpdate update) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeScheduledUpdate(int x, int y, int z, ScheduledBlockUpdate update) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> Optional<T> getData(Vector3i position, Class<T> dataClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> Optional<T> getData(int x, int y, int z, Class<T> dataClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> Optional<T> getOrCreate(Vector3i position, Class<T> manipulatorClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> Optional<T> getOrCreate(int x, int y, int z, Class<T> manipulatorClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> boolean remove(Vector3i position, Class<T> manipulatorClass) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> boolean remove(int x, int y, int z, Class<T> manipulatorClass) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> boolean isCompatible(Vector3i position, Class<T> manipulatorClass) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> boolean isCompatible(int x, int y, int z, Class<T> manipulatorClass) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> DataTransactionResult offer(Vector3i position, T manipulatorData) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> DataTransactionResult offer(int x, int y, int z, T manipulatorData) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> DataTransactionResult offer(Vector3i position, T manipulatorData, DataPriority priority) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends DataManipulator<T>> DataTransactionResult offer(int x, int y, int z, T manipulatorData, DataPriority priority) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <E> java.util.Optional<E> get(int i, int i1, int i2, Key<? extends BaseValue<E>> key) {
        return null;
    }

    @Override
    public <T extends DataManipulator<?, ?>> java.util.Optional<T> get(int i, int i1, int i2, Class<T> aClass) {
        return null;
    }

    @Override
    public <T extends DataManipulator<?, ?>> java.util.Optional<T> getOrCreate(int i, int i1, int i2, Class<T> aClass) {
        return null;
    }

    @Override
    public <E, V extends BaseValue<E>> java.util.Optional<V> getValue(int i, int i1, int i2, Key<V> key) {
        return null;
    }

    @Override
    public boolean supports(int i, int i1, int i2, Key<?> key) {
        return false;
    }

    @Override
    public boolean supports(int i, int i1, int i2, Class<? extends DataManipulator<?, ?>> aClass) {
        return false;
    }

    @Override
    public Set<Key<?>> getKeys(int i, int i1, int i2) {
        return null;
    }

    @Override
    public Set<ImmutableValue<?>> getValues(int i, int i1, int i2) {
        return null;
    }

    @Override
    public <E> DataTransactionResult offer(int i, int i1, int i2, Key<? extends BaseValue<E>> key, E e) {
        return null;
    }

    @Override
    public DataTransactionResult offer(int i, int i1, int i2, DataManipulator<?, ?> dataManipulator, MergeFunction mergeFunction) {
        return null;
    }

    @Override
    public DataTransactionResult remove(int i, int i1, int i2, Class<? extends DataManipulator<?, ?>> aClass) {
        return null;
    }

    @Override
    public DataTransactionResult remove(int i, int i1, int i2, Key<?> key) {
        return null;
    }

    @Override
    public DataTransactionResult undo(int i, int i1, int i2, DataTransactionResult dataTransactionResult) {
        return null;
    }

    @Override
    public DataTransactionResult copyFrom(int i, int i1, int i2, DataHolder dataHolder) {
        return null;
    }

    @Override
    public DataTransactionResult copyFrom(int i, int i1, int i2, DataHolder dataHolder, MergeFunction mergeFunction) {
        return null;
    }

    @Override
    public DataTransactionResult copyFrom(int i, int i1, int i2, int i3, int i4, int i5, MergeFunction mergeFunction) {
        return null;
    }

    @Override
    public Collection<? extends DataManipulator<?>> getManipulators(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<? extends DataManipulator<?>> getManipulators(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean validateRawData(int i, int i1, int i2, DataView dataView) {
        return false;
    }

    @Override
    public void setRawData(int i, int i1, int i2, DataView dataView) throws InvalidDataException {

    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(Vector3i position, Class<T> propertyClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(int x, int y, int z, Class<T> propertyClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Property<?, ?>> java.util.Optional<T> getProperty(int i, int i1, int i2, Direction direction, Class<T> aClass) {
        return null;
    }

    @Override
    public Collection<? extends Property<?, ?>> getProperties(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<? extends Property<?, ?>> getProperties(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Direction> getFacesWithProperty(int i, int i1, int i2, Class<? extends Property<?, ?>> aClass) {
        return null;
    }

    @Override
    public boolean validateRawData(Vector3i position, DataContainer container) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean validateRawData(int x, int y, int z, DataContainer container) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRawData(Vector3i position, DataContainer container) throws InvalidDataException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setRawData(int x, int y, int z, DataContainer container) throws InvalidDataException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector2i getBiomeMin() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector2i getBiomeMax() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector2i getBiomeSize() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean containsBiome(Vector2i vector2i) {
        return false;
    }

    @Override
    public boolean containsBiome(int i, int i1) {
        return false;
    }

    @Override
    public BiomeType getBiome(Vector2i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BiomeType getBiome(int x, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UnmodifiableBiomeArea getUnmodifiableBiomeView() {
        return null;
    }

    @Override
    public MutableBiomeArea getBiomeCopy() {
        return null;
    }

    @Override
    public MutableBiomeArea getBiomeCopy(StorageType storageType) {
        return null;
    }

    @Override
    public ImmutableBiomeArea getImmutableBiomeCopy() {
        return null;
    }

    @Override
    public void setBiome(Vector2i position, BiomeType biome) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBiome(int x, int z, BiomeType biome) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MutableBiomeArea getBiomeView(Vector2i vector2i, Vector2i vector2i1) {
        return null;
    }

    @Override
    public MutableBiomeArea getBiomeView(DiscreteTransform2 discreteTransform2) {
        return null;
    }

    @Override
    public MutableBiomeArea getRelativeBiomeView() {
        return null;
    }

    @Override
    public Collection<Entity> getEntities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Entity> getEntities(java.util.function.Predicate<Entity> predicate) {
        return null;
    }

    @Override
    public Collection<Entity> getEntities(Predicate<Entity> filter) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<Entity> createEntity(EntityType type, Vector3d position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<Entity> createEntity(EntityType type, Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<Entity> createEntity(DataContainer entityContainer) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<Entity> createEntity(DataContainer entityContainer, Vector3d position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public java.util.Optional<Entity> restoreSnapshot(EntitySnapshot entitySnapshot, Vector3d vector3d) {
        return null;
    }

    @Override
    public boolean spawnEntity(Entity entity, Cause cause) {
        return false;
    }

    @Override
    public boolean spawnEntity(Entity entity) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UUID getUniqueId() {
        return this.handle.getUID();
    }

    @Override
    public Collection<TileEntity> getTileEntities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<TileEntity> getTileEntities(java.util.function.Predicate<TileEntity> predicate) {
        return null;
    }

    @Override
    public Collection<TileEntity> getTileEntities(Predicate<TileEntity> filter) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<TileEntity> getTileEntity(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<TileEntity> getTileEntity(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<TileEntity> getTileEntity(Location blockLoc) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector3i getBlockMin() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector3i getBlockMax() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector3i getBlockSize() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean containsBlock(Vector3i vector3i) {
        return false;
    }

    @Override
    public boolean containsBlock(int i, int i1, int i2) {
        return false;
    }

    @Override
    public BlockState getBlock(Vector3i position) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BlockState getBlock(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBlock(Vector3i position, BlockState block) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setBlock(int x, int y, int z, BlockState block) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void spawnParticles(ParticleEffect particleEffect, Vector3d position) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void spawnParticles(ParticleEffect particleEffect, Vector3d position, int radius) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playSound(SoundType sound, Vector3d position, double volume) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playSound(SoundType sound, Vector3d position, double volume, double pitch) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playSound(SoundType sound, Vector3d position, double volume, double pitch, double minVolume) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendMessage(ChatType chatType, Text text) {

    }

    @Override
    public void sendMessages(ChatType chatType, Text... texts) {

    }

    @Override
    public void sendMessages(ChatType chatType, Iterable<Text> iterable) {

    }

    @Override
    public void sendMessage(ChatType type, String... message) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendMessage(ChatType type, Text... messages) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendMessage(ChatType type, Iterable<Text> messages) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendTitle(Title title) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resetTitle() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void clearTitle() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Weather getWeather() {
        if (this.handle.hasStorm()) {
            return Weathers.RAIN;
        } else if (this.handle.isThundering()) {
            return Weathers.THUNDER_STORM;
        } else {
            return Weathers.CLEAR;
        }
    }

    @Override
    public long getRemainingDuration() {
        return this.handle.getWeatherDuration() != 0 ? this.handle.getWeatherDuration() : this.handle.getThunderDuration();
    }

    @Override
    public long getRunningDuration() {
        // TODO: doesn't appear the Bukkit API exposes running weather duration?
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void forecast(Weather weather) {
        if (weather == Weathers.RAIN) {
            this.handle.setStorm(true);
        } else if (weather == Weathers.THUNDER_STORM) {
            this.handle.setThundering(true);
        } else if (weather == Weathers.CLEAR) {
            this.handle.setStorm(false);
            this.handle.setThundering(false);
        }
    }

    @Override
    public void forecast(Weather weather, long duration) {
        this.forecast(weather);

        if (weather == Weathers.RAIN) {
            this.handle.setWeatherDuration((int) duration);
        } else if (weather == Weathers.THUNDER_STORM) {
            this.handle.setThunderDuration((int) duration);
        }
    }

    @Override
    public boolean hitBlock(int i, int i1, int i2, Direction direction, Cause cause) {
        return false;
    }

    @Override
    public boolean interactBlock(int i, int i1, int i2, Direction direction, Cause cause) {
        return false;
    }

    @Override
    public boolean interactBlockWith(int i, int i1, int i2, ItemStack itemStack, Direction direction, Cause cause) {
        return false;
    }

    @Override
    public boolean placeBlock(int i, int i1, int i2, BlockState blockState, Direction direction, Cause cause) {
        return false;
    }

    @Override
    public boolean digBlock(int i, int i1, int i2, Cause cause) {
        return false;
    }

    @Override
    public boolean digBlockWith(int i, int i1, int i2, ItemStack itemStack, Cause cause) {
        return false;
    }

    @Override
    public int getBlockDigTimeWith(int i, int i1, int i2, ItemStack itemStack, Cause cause) {
        return 0;
    }
}
