package net.glowstone.bukkit2sponge.plugin;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.glowstone.bukkit2sponge.Bukkit2Sponge;
import net.glowstone.bukkit2sponge.ShinyGame;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Implementation of {@link PluginManager}.
 */

@Singleton
public class ShinyPluginManager implements PluginManager {

    private final ShinyGame game;
    private final PluginLoader loader;

    private final Map<String, PluginContainer> plugins = new HashMap<>();
    private final Map<Object, PluginContainer> instanceMap = new IdentityHashMap<>();

    @Inject
    public ShinyPluginManager(ShinyGame game) {
        this.game = game;
        loader = new PluginLoader(game);
    }

    @Override
    public Optional<PluginContainer> fromInstance(Object instance) {
        return Optional.ofNullable(instanceMap.get(instance));
    }

    @Override
    public Optional<PluginContainer> getPlugin(String id) {
        return Optional.ofNullable(plugins.get(id));
    }

    @Override
    public Collection<PluginContainer> getPlugins() {
        return plugins.values();
    }

    @Override
    public boolean isLoaded(String id) {
        return plugins.containsKey(id);
    }

    /**
     * Load a directory full of plugins
     *
     * @return List of recognized SpongeAPI plugin URLs
     * @throws IOException
     */
    public Collection<URL> loadPlugins(List<URL> urls) throws IOException {
        Collection<PluginContainer> containers = loader.loadPlugins(urls);
        for (PluginContainer container : containers) {
            if (plugins.containsKey(container.getId())) {
                Bukkit2Sponge.instance.getLogger().warning("Skipped loading duplicate of \"" + container.getId() + "\"");
                continue;
            }
            Bukkit2Sponge.instance.getLogger().info("SpongeAPI plugin found: "+container.getName()+" v"+container.getVersion());
            plugins.put(container.getId(), container);
            instanceMap.put(container.getInstance(), container);
            game.getEventManager().registerListeners(container.getInstance(), container.getInstance());
        }

        return urls;
    }
}
