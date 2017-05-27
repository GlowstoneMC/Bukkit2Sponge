package net.glowstone.bukkit2sponge.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import net.glowstone.bukkit2sponge.Bukkit2Sponge;
import net.glowstone.bukkit2sponge.ShinyGame;
import net.glowstone.bukkit2sponge.ShinyGameRegistry;
import net.glowstone.bukkit2sponge.plugin.ShinyPluginManager;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.plugin.PluginManager;

import java.io.File;

public class ShinyGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Bukkit2Sponge.class).toInstance(Bukkit2Sponge.instance);
        bind(Game.class).to(ShinyGame.class).in(Scopes.SINGLETON);
        bind(PluginManager.class).to(ShinyPluginManager.class).in(Scopes.SINGLETON);
        bind(GameRegistry.class).to(ShinyGameRegistry.class).in(Scopes.SINGLETON);
        bind(File.class).annotatedWith(new ConfigDirAnnotation(true)).toInstance(Bukkit2Sponge.instance.getConfigDirectory());
    }
}
