package net.glowstone.bukkit2sponge;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.type.Art;
import org.spongepowered.api.data.value.ValueFactory;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.ai.task.AITaskType;
import org.spongepowered.api.entity.ai.task.AbstractAITask;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.merchant.VillagerRegistry;
import org.spongepowered.api.item.recipe.RecipeRegistry;
import org.spongepowered.api.network.status.Favicon;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.CatalogTypeAlreadyRegisteredException;
import org.spongepowered.api.registry.RegistryModule;
import org.spongepowered.api.registry.RegistryModuleAlreadyRegisteredException;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.statistic.BlockStatistic;
import org.spongepowered.api.statistic.EntityStatistic;
import org.spongepowered.api.statistic.ItemStatistic;
import org.spongepowered.api.statistic.StatisticType;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.selector.SelectorFactory;
import org.spongepowered.api.text.serializer.TextSerializerFactory;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.extent.ExtentBufferFactory;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Supplier;

/**
 * Implementation of {@link GameRegistry}.
 */
public class ShinyGameRegistry implements GameRegistry {

    private final Map<String, BlockType> blocks = new HashMap<>();
    private final Map<String, ItemType> items = new HashMap<>();
    private final Map<String, Art> arts = new HashMap<>();
    private final Map<String, Rotation> rotations = new HashMap<>();
    private final Map<Object, String> idMap = new IdentityHashMap<>();

    private void register(BlockType block) {
        blocks.put(block.getId(), block);
        idMap.put(block, block.getId());
    }

    private void register(ItemType item) {
        items.put(item.getId(), item);
        idMap.put(item, item.getId());
    }


    @Override
    public <T extends CatalogType> Optional<T> getType(Class<T> tClass, String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends CatalogType> Collection<T> getAllOf(Class<T> tClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends CatalogType> Collection<T> getAllFor(String pluginId, Class<T> typeClass) {
        return null;
    }

    @Override
    public <T extends CatalogType> GameRegistry registerModule(Class<T> catalogClass, CatalogRegistryModule<T> registryModule) throws IllegalArgumentException, RegistryModuleAlreadyRegisteredException {
        return null;
    }

    @Override
    public GameRegistry registerModule(RegistryModule module) throws RegistryModuleAlreadyRegisteredException {
        return null;
    }

    @Override
    public <T> GameRegistry registerBuilderSupplier(Class<T> builderClass, Supplier<? extends T> supplier) {
        return null;
    }

    @Override
    public <T extends ResettableBuilder<?, ? super T>> T createBuilder(Class<T> builderClass) throws IllegalArgumentException {
        return null;
    }

    @Override
    public <T extends CatalogType> T register(Class<T> type, T obj) throws IllegalArgumentException, CatalogTypeAlreadyRegisteredException {
        return null;
    }

    @Override
    public Optional<Rotation> getRotationFromDegree(int degrees) {
        return Optional.ofNullable(rotations.get(degrees)); // TODO: int -> Rotation
    }

    @Override
    public Favicon loadFavicon(String raw) throws IOException {
        return null;
    }

    @Override
    public Favicon loadFavicon(Path path) throws IOException {
        return null;
    }

    @Override
    public Collection<String> getDefaultGameRules() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<EntityStatistic> getEntityStatistic(StatisticType statType, EntityType entityType) {
        return null;
    }

    @Override
    public Optional<ItemStatistic> getItemStatistic(StatisticType statType, ItemType itemType) {
        return null;
    }

    @Override
    public Optional<BlockStatistic> getBlockStatistic(StatisticType statType, BlockType blockType) {
        return null;
    }

    @Override
    public Favicon loadFavicon(URL url) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Favicon loadFavicon(InputStream in) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Favicon loadFavicon(BufferedImage image) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RecipeRegistry getRecipeRegistry() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<ResourcePack> getResourcePackById(String id) {
        return null;
    }

    @Override
    public Optional<DisplaySlot> getDisplaySlotForColor(TextColor color) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AITaskType registerAITaskType(Object plugin, String id, String name, Class<? extends AbstractAITask<? extends Agent>> aiClass) {
        return null;
    }

    @Override
    public ExtentBufferFactory getExtentBufferFactory() {
        return null;
    }

    @Override
    public ValueFactory getValueFactory() {
        return null;
    }

    @Override
    public VillagerRegistry getVillagerRegistry() {
        return null;
    }

    @Override
    public TextSerializerFactory getTextSerializerFactory() {
        return null;
    }

    @Override
    public SelectorFactory getSelectorFactory() {
        return null;
    }

    @Override
    public Locale getLocale(String locale) {
        return null;
    }

    @Override
    public Optional<Translation> getTranslationById(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
