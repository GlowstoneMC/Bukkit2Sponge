package io.github.deathcap.bukkit2sponge.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import io.github.deathcap.bukkit2sponge.Bukkit2Sponge;
import io.github.deathcap.bukkit2sponge.ShinyGame;
import io.github.deathcap.bukkit2sponge.ShinyGameRegistry;
import io.github.deathcap.bukkit2sponge.event.ShinyEventManager;
import io.github.deathcap.bukkit2sponge.plugin.ShinyPluginManager;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.service.event.EventManager;

import java.io.File;

public class ShinyGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Bukkit2Sponge.class).toInstance(Bukkit2Sponge.instance);
        bind(Game.class).to(ShinyGame.class).in(Scopes.SINGLETON);
        bind(PluginManager.class).to(ShinyPluginManager.class).in(Scopes.SINGLETON);
        bind(EventManager.class).to(ShinyEventManager.class).in(Scopes.SINGLETON);
        bind(GameRegistry.class).to(ShinyGameRegistry.class).in(Scopes.SINGLETON);
        bind(File.class).annotatedWith(new ConfigDirAnnotation(true)).toInstance(Bukkit2Sponge.instance.getConfigDirectory());
    }
}
