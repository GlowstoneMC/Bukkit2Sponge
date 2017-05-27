package net.glowstone.bukkit2sponge.world;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.ScheduledBlockUpdate;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.*;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.sound.SoundCategory;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.text.BookView;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.DiscreteTransform3;
import org.spongepowered.api.world.*;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.difficulty.Difficulties;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.extent.*;
import org.spongepowered.api.world.extent.worker.MutableBiomeVolumeWorker;
import org.spongepowered.api.world.extent.worker.MutableBlockVolumeWorker;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.storage.WorldStorage;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.Weathers;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

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
    public Optional<String> getGameRule(String gameRule) {
        return Optional.of(this.handle.getGameRuleValue(gameRule));
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
        return null;
    }

    @Override
    public void triggerExplosion(Explosion explosion, Cause cause) {

    }

    @Override
    public PortalAgent getPortalAgent() {
        return null;
    }

    @Override
    public int getHighestYAt(int x, int z) {
        return 0;
    }

    @Override
    public boolean setBlock(int x, int y, int z, BlockState blockState, BlockChangeFlag flag, Cause cause) {
        return false;
    }

    @Override
    public BlockSnapshot createSnapshot(int x, int y, int z) {
        return null;
    }

    @Override
    public boolean restoreSnapshot(BlockSnapshot snapshot, boolean force, BlockChangeFlag flag, Cause cause) {
        return false;
    }

    @Override
    public boolean restoreSnapshot(int x, int y, int z, BlockSnapshot snapshot, boolean force, BlockChangeFlag flag, Cause cause) {
        return false;
    }

    @Override
    public Collection<ScheduledBlockUpdate> getScheduledUpdates(int x, int y, int z) {
        return null;
    }

    @Override
    public ScheduledBlockUpdate addScheduledUpdate(int x, int y, int z, int priority, int ticks) {
        return null;
    }

    @Override
    public void removeScheduledUpdate(int x, int y, int z, ScheduledBlockUpdate update) {

    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public Extent getExtentView(Vector3i newMin, Vector3i newMax) {
        return null;
    }

    @Override
    public Vector3i getBiomeMin() {
        return null;
    }

    @Override
    public Vector3i getBiomeMax() {
        return null;
    }

    @Override
    public Vector3i getBiomeSize() {
        return null;
    }

    @Override
    public boolean containsBiome(int x, int y, int z) {
        return false;
    }

    @Override
    public BiomeType getBiome(int x, int y, int z) {
        return null;
    }

    @Override
    public UnmodifiableBiomeVolume getUnmodifiableBiomeView() {
        return null;
    }

    @Override
    public MutableBiomeVolume getBiomeCopy(StorageType type) {
        return null;
    }

    @Override
    public ImmutableBiomeVolume getImmutableBiomeCopy() {
        return null;
    }

    @Override
    public void setBiome(int x, int y, int z, BiomeType biome) {

    }

    @Override
    public MutableBiomeVolume getBiomeView(Vector3i newMin, Vector3i newMax) {
        return null;
    }

    @Override
    public MutableBiomeVolume getBiomeView(DiscreteTransform3 transform) {
        return null;
    }

    @Override
    public MutableBiomeVolumeWorker<World> getBiomeWorker() {
        return null;
    }

    @Override
    public boolean hitBlock(int x, int y, int z, Direction side, Cause cause) {
        return false;
    }

    @Override
    public boolean interactBlock(int x, int y, int z, Direction side, Cause cause) {
        return false;
    }

    @Override
    public boolean interactBlockWith(int x, int y, int z, ItemStack itemStack, Direction side, Cause cause) {
        return false;
    }

    @Override
    public boolean placeBlock(int x, int y, int z, BlockState block, Direction side, Cause cause) {
        return false;
    }

    @Override
    public boolean digBlock(int x, int y, int z, Cause cause) {
        return false;
    }

    @Override
    public boolean digBlockWith(int x, int y, int z, ItemStack itemStack, Cause cause) {
        return false;
    }

    @Override
    public int getBlockDigTimeWith(int x, int y, int z, ItemStack itemStack, Cause cause) {
        return 0;
    }

    @Override
    public Vector3i getBlockMin() {
        return null;
    }

    @Override
    public Vector3i getBlockMax() {
        return null;
    }

    @Override
    public Vector3i getBlockSize() {
        return null;
    }

    @Override
    public boolean containsBlock(int x, int y, int z) {
        return false;
    }

    @Override
    public BlockState getBlock(int x, int y, int z) {
        return null;
    }

    @Override
    public BlockType getBlockType(int x, int y, int z) {
        return null;
    }

    @Override
    public UnmodifiableBlockVolume getUnmodifiableBlockView() {
        return null;
    }

    @Override
    public MutableBlockVolume getBlockCopy(StorageType type) {
        return null;
    }

    @Override
    public ImmutableBlockVolume getImmutableBlockCopy() {
        return null;
    }

    @Override
    public Collection<TileEntity> getTileEntities() {
        return null;
    }

    @Override
    public Collection<TileEntity> getTileEntities(Predicate<TileEntity> filter) {
        return null;
    }

    @Override
    public Optional<TileEntity> getTileEntity(int x, int y, int z) {
        return null;
    }

    @Override
    public boolean setBlock(int x, int y, int z, BlockState block, Cause cause) {
        return false;
    }

    @Override
    public MutableBlockVolume getBlockView(Vector3i newMin, Vector3i newMax) {
        return null;
    }

    @Override
    public MutableBlockVolume getBlockView(DiscreteTransform3 transform) {
        return null;
    }

    @Override
    public MutableBlockVolumeWorker<World> getBlockWorker(Cause cause) {
        return null;
    }

    @Override
    public Optional<UUID> getCreator(int x, int y, int z) {
        return null;
    }

    @Override
    public Optional<UUID> getNotifier(int x, int y, int z) {
        return null;
    }

    @Override
    public void setCreator(int x, int y, int z, @Nullable UUID uuid) {

    }

    @Override
    public void setNotifier(int x, int y, int z, @Nullable UUID uuid) {

    }

    @Override
    public Optional<AABB> getBlockSelectionBox(int x, int y, int z) {
        return null;
    }

    @Override
    public Set<AABB> getIntersectingBlockCollisionBoxes(AABB box) {
        return null;
    }

    @Override
    public Set<AABB> getIntersectingCollisionBoxes(Entity owner, AABB box) {
        return null;
    }

    @Override
    public ArchetypeVolume createArchetypeVolume(Vector3i min, Vector3i max, Vector3i origin) {
        return null;
    }

    @Override
    public boolean save() throws IOException {
        return false;
    }

    @Override
    public Collection<Player> getPlayers() {
        return null;
    }

    @Override
    public Optional<Chunk> getChunk(int cx, int cy, int cz) {
        return null;
    }

    @Override
    public Optional<Chunk> loadChunk(int cx, int cy, int cz, boolean shouldGenerate) {
        return null;
    }

    @Override
    public boolean unloadChunk(Chunk chunk) {
        return false;
    }

    @Override
    public Iterable<Chunk> getLoadedChunks() {
        return null;
    }

    @Override
    public Optional<Entity> getEntity(UUID uuid) {
        return null;
    }

    @Override
    public Collection<Entity> getEntities() {
        return null;
    }

    @Override
    public Collection<Entity> getEntities(Predicate<Entity> filter) {
        return null;
    }

    @Override
    public Entity createEntity(EntityType type, Vector3d position) throws IllegalArgumentException, IllegalStateException {
        return null;
    }

    @Override
    public Optional<Entity> createEntity(DataContainer entityContainer) {
        return null;
    }

    @Override
    public Optional<Entity> createEntity(DataContainer entityContainer, Vector3d position) {
        return null;
    }

    @Override
    public Entity createEntityNaturally(EntityType type, Vector3d position) throws IllegalArgumentException, IllegalStateException {
        return null;
    }

    @Override
    public Optional<Entity> restoreSnapshot(EntitySnapshot snapshot, Vector3d position) {
        return null;
    }

    @Override
    public boolean spawnEntity(Entity entity, Cause cause) {
        return false;
    }

    @Override
    public boolean spawnEntities(Iterable<? extends Entity> entities, Cause cause) {
        return false;
    }

    @Override
    public Set<Entity> getIntersectingEntities(AABB box, Predicate<Entity> filter) {
        return null;
    }

    @Override
    public Set<EntityHit> getIntersectingEntities(Vector3d start, Vector3d end, Predicate<EntityHit> filter) {
        return null;
    }

    @Override
    public Set<EntityHit> getIntersectingEntities(Vector3d start, Vector3d direction, double distance, Predicate<EntityHit> filter) {
        return null;
    }

    @Override
    public WorldBorder getWorldBorder() {
        return null;
    }

    @Override
    public ChunkPreGenerate.Builder newChunkPreGenerate(Vector3d center, double diameter) {
        return null;
    }

    @Override
    public Dimension getDimension() {
        return null;
    }

    @Override
    public WorldGenerator getWorldGenerator() {
        return null;
    }

    @Override
    public WorldProperties getProperties() {
        return null;
    }

    @Override
    public Path getDirectory() {
        return null;
    }

    @Override
    public UUID getUniqueId() {
        return this.handle.getUID();
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
    public void setWeather(Weather weather) {

    }

    @Override
    public void setWeather(Weather weather, long duration) {

    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(int x, int y, int z, Class<T> propertyClass) {
        return null;
    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(int x, int y, int z, Direction direction, Class<T> propertyClass) {
        return null;
    }

    @Override
    public Collection<Property<?, ?>> getProperties(int x, int y, int z) {
        return null;
    }

    @Override
    public Collection<Direction> getFacesWithProperty(int x, int y, int z, Class<? extends Property<?, ?>> propertyClass) {
        return null;
    }

    @Override
    public void spawnParticles(ParticleEffect particleEffect, Vector3d position) {

    }

    @Override
    public void spawnParticles(ParticleEffect particleEffect, Vector3d position, int radius) {

    }

    @Override
    public void playSound(SoundType sound, SoundCategory category, Vector3d position, double volume) {

    }

    @Override
    public void playSound(SoundType sound, SoundCategory category, Vector3d position, double volume, double pitch) {

    }

    @Override
    public void playSound(SoundType sound, SoundCategory category, Vector3d position, double volume, double pitch, double minVolume) {

    }

    @Override
    public void sendTitle(Title title) {

    }

    @Override
    public void sendBookView(BookView bookView) {

    }

    @Override
    public void sendBlockChange(int x, int y, int z, BlockState state) {

    }

    @Override
    public void resetBlockChange(int x, int y, int z) {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void sendMessage(ChatType type, Text message) {

    }

    @Override
    public void sendMessage(Text message) {

    }

    @Override
    public MessageChannel getMessageChannel() {
        return null;
    }

    @Override
    public void setMessageChannel(MessageChannel channel) {

    }

    @Override
    public <E> Optional<E> get(int x, int y, int z, Key<? extends BaseValue<E>> key) {
        return null;
    }

    @Override
    public <T extends DataManipulator<?, ?>> Optional<T> get(int x, int y, int z, Class<T> manipulatorClass) {
        return null;
    }

    @Override
    public <T extends DataManipulator<?, ?>> Optional<T> getOrCreate(int x, int y, int z, Class<T> manipulatorClass) {
        return null;
    }

    @Override
    public <E, V extends BaseValue<E>> Optional<V> getValue(int x, int y, int z, Key<V> key) {
        return null;
    }

    @Override
    public boolean supports(int x, int y, int z, Key<?> key) {
        return false;
    }

    @Override
    public boolean supports(int x, int y, int z, Class<? extends DataManipulator<?, ?>> manipulatorClass) {
        return false;
    }

    @Override
    public Set<Key<?>> getKeys(int x, int y, int z) {
        return null;
    }

    @Override
    public Set<ImmutableValue<?>> getValues(int x, int y, int z) {
        return null;
    }

    @Override
    public <E> DataTransactionResult offer(int x, int y, int z, Key<? extends BaseValue<E>> key, E value) {
        return null;
    }

    @Override
    public <E> DataTransactionResult offer(int x, int y, int z, Key<? extends BaseValue<E>> key, E value, Cause cause) {
        return null;
    }

    @Override
    public DataTransactionResult offer(int x, int y, int z, DataManipulator<?, ?> manipulator, MergeFunction function) {
        return null;
    }

    @Override
    public DataTransactionResult offer(int x, int y, int z, DataManipulator<?, ?> manipulator, MergeFunction function, Cause cause) {
        return null;
    }

    @Override
    public DataTransactionResult remove(int x, int y, int z, Class<? extends DataManipulator<?, ?>> manipulatorClass) {
        return null;
    }

    @Override
    public DataTransactionResult remove(int x, int y, int z, Key<?> key) {
        return null;
    }

    @Override
    public DataTransactionResult undo(int x, int y, int z, DataTransactionResult result) {
        return null;
    }

    @Override
    public DataTransactionResult copyFrom(int xTo, int yTo, int zTo, DataHolder from) {
        return null;
    }

    @Override
    public DataTransactionResult copyFrom(int xTo, int yTo, int zTo, DataHolder from, MergeFunction function) {
        return null;
    }

    @Override
    public DataTransactionResult copyFrom(int xTo, int yTo, int zTo, int xFrom, int yFrom, int zFrom, MergeFunction function) {
        return null;
    }

    @Override
    public Collection<DataManipulator<?, ?>> getManipulators(int x, int y, int z) {
        return null;
    }

    @Override
    public boolean validateRawData(int x, int y, int z, DataView container) {
        return false;
    }

    @Override
    public void setRawData(int x, int y, int z, DataView container) throws InvalidDataException {

    }
}
