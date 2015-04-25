package io.github.deathcap.bukkit2sponge.command;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.bukkit.Bukkit;
import org.spongepowered.api.Game;
import org.spongepowered.api.service.command.SimpleCommandService;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.dispatcher.Disambiguator;

import java.util.List;

public class ShinyCommandService extends SimpleCommandService {
    public ShinyCommandService(Game game) {
        super(game);
    }

    public ShinyCommandService(Game game, Disambiguator disambiguator) {
        super(game, disambiguator);
    }

    @Override
    public Optional<CommandMapping> register(Object plugin, CommandCallable callable, List<String> aliases,
                                             Function<List<String>, List<String>> callback) {
        Optional<CommandMapping> result = super.register(plugin, callable, aliases, callback);

        if (result.isPresent()) {
            // TODO Bukkit.getPluginManager().
        }

        return result;
    }
}
