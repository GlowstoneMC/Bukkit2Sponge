
package io.github.deathcap.bukkit2sponge;

import com.google.common.base.Throwables;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.deathcap.bukkit2sponge.event.GraniteEventFactory;
import io.github.deathcap.bukkit2sponge.guice.ShinyGuiceModule;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.event.state.ConstructionEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.StateEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

public class Bukkit2Sponge extends JavaPlugin {

    public static final Bukkit2Sponge instance = new Bukkit2Sponge();

    public static Logger getLogger() {
        return instance.logger;
    }

    public Injector getInjector() {
        return injector;
    }

    private Injector injector;
    public Logger logger;

    private ShinyGame game;

    @Override
    public void onDisable() {
        getLogger().info("Goodbye world!");
    }

    @Override
    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );

        load();
    }

    public Collection<URL> load() {
        Collection<URL> loadedPluginURLs = null;

        try {
            logger = LoggerFactory.getLogger("Bukkit2Sponge");
            injector = Guice.createInjector(new ShinyGuiceModule());

            /*
             CONSTRUCTION,
             LOAD_COMPLETE,
             PRE_INITIALIZATION,
             INITIALIZATION,
             POST_INITIALIZATION,
             SERVER_ABOUT_TO_START,
             SERVER_STARTING,
             SERVER_STARTED,
             SERVER_STOPPING,
             SERVER_STOPPED
             */

            getLogger().info("Loading Bukkit2Sponge...");
            this.game = injector.getInstance(ShinyGame.class);

            getLogger().info("Bukkit2Sponge " + this.game.getImplementationVersion() + " is starting...");
            getLogger().info("SpongeAPI version: " + this.game.getApiVersion());

            getLogger().info("Loading plugins...");
            loadedPluginURLs = this.game.getPluginManager().loadPlugins();
            postState(ConstructionEvent.class);
            getLogger().info("Initializing " + loadedPluginURLs.size() + " SpongeAPI plugins...");
            postState(PreInitializationEvent.class);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }

        return loadedPluginURLs;
    }

    public ShinyGame getGame() {
        return this.game;
    }

    public void postState(Class<? extends StateEvent> type) {
        this.game.getEventManager().post(GraniteEventFactory.createStateEvent(type, this.game));
    }

    public File getPluginsDirectory() {
        return new File("plugins"); // TODO
    }

    public File getConfigDirectory() {
        return new File("config"); // TODO
    }
}