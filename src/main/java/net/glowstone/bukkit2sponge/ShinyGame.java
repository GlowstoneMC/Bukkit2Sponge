package net.glowstone.bukkit2sponge;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.glowstone.bukkit2sponge.plugin.ShinyPluginManager;
import net.glowstone.bukkit2sponge.text.ShinyTextFactory;
import org.bukkit.Bukkit;
import org.spongepowered.api.*;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.service.SimpleServiceManager;
import org.spongepowered.api.world.TeleportHelper;

import java.nio.file.Path;
import java.util.Map;

/**
 * Implementation of {@link Game}.
 */

@Singleton
public class ShinyGame implements Game {

    private final ShinyPluginManager pluginManager = new ShinyPluginManager(this);
    private final ShinyGameRegistry registry = new ShinyGameRegistry();
    private final SimpleServiceManager services = new SimpleServiceManager(pluginManager);
    private final ShinyServer server = new ShinyServer(Bukkit.getServer());

    private static final String API_VERSION;
    private static final String IMPL_VERSION;

    static {
        Package pkg = ShinyGame.class.getPackage();
        String apiVersion = pkg.getSpecificationVersion();
        API_VERSION = (apiVersion == null) ? "unknown" : apiVersion;
        String implVersion = pkg.getImplementationVersion();
        IMPL_VERSION = (implVersion == null) ? "unknown" : implVersion;
        ShinyTextFactory.inject();
    }

    @Inject
    public ShinyGame() {

    }

    // platform information

    @Override
    public Platform getPlatform() {
        return new Platform() {
            @Override
            public Type getType() {
                return Type.SERVER;
            }

            @Override
            public Type getExecutionType() {
                return Type.SERVER;
            }

            @Override
            public PluginContainer getContainer(Component component) {
                return null;
            }

            @Override
            public MinecraftVersion getMinecraftVersion() {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
    }

    private GameState state;

    @Override
    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    @Override
    public Path getGameDirectory() {
        return null;
    }

    @Override
    public Path getSavesDirectory() {
        return null;
    }

    @Override
    public boolean isServerAvailable() {
        return false;
    }

    @Override
    public Server getServer() {
        return server;
    }

    @Override
    public GameDictionary getGameDictionary() {
        return null;
    }

    @Override
    public TeleportHelper getTeleportHelper() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    // service access

    @Override
    public ShinyPluginManager getPluginManager() {
        return pluginManager;
    }

    @Override
    public GameRegistry getRegistry() {
        return registry;
    }

    @Override
    public ServiceManager getServiceManager() {
        return services;
    }
}
