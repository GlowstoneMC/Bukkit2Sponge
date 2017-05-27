package net.glowstone.bukkit2sponge.command;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import net.glowstone.bukkit2sponge.ShinyGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.PluginManager;
import org.spongepowered.api.service.command.SimpleCommandService;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.dispatcher.Disambiguator;

import java.lang.reflect.Field;
import java.util.List;

public class ShinyCommandService extends SimpleCommandService {
    private ShinyGame game;

    public ShinyCommandService(ShinyGame game) {
        super(game);
        this.game = game;
    }

    public ShinyCommandService(ShinyGame game, Disambiguator disambiguator) {
        super(game, disambiguator);
        this.game = game;
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandCallable callable, List<String> aliases,
                                             Function<List<String>, List<String>> callback) {
        Optional<CommandMapping> result = super.register(plugin, callable, aliases, callback);

        if (result.isPresent()) {
            CommandMapping commandMapping = result.get();

            String label = commandMapping.getPrimaryAlias();
            String fallbackPrefix = "sponge";
            BukkitCommand bukkitCommand = new BukkitCommand(commandMapping);

            registerBukkitCommand(label, fallbackPrefix, bukkitCommand);
        }

        return result;
    }

    private boolean registerBukkitCommand(String label, String fallbackPrefix, Command command) {
        PluginManager pluginManager = Bukkit.getPluginManager();

        try {
            // https://bukkit.org/threads/dynamic-registration-of-commands.65786/
            // annoyingly, Bukkit normally only allows static command registration in plugin.yml, the command
            // registration field needed for dynamic registration is private TODO: public
            Field field = pluginManager.getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            SimpleCommandMap commandMap = (SimpleCommandMap) field.get(pluginManager);

            return commandMap.register(label, fallbackPrefix, command);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
