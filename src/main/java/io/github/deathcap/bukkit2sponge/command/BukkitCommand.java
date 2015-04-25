package io.github.deathcap.bukkit2sponge.command;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;

import java.util.ArrayList;

public class BukkitCommand extends Command {

    private CommandMapping commandMapping;
    private static ShinyConsoleSource commandSource = new ShinyConsoleSource("console"); // TODO

    public BukkitCommand(CommandMapping commandMapping) {
        super(commandMapping.getPrimaryAlias(),
                commandMapping.getCallable().getShortDescription(commandSource).toString(),
                commandMapping.getCallable().getUsage(commandSource).toString(),
                new ArrayList<>(commandMapping.getAllAliases())); // TODO: remove primary alias?

        this.commandMapping = commandMapping;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {

        //CommandSource commandSource = commandSource; // TODO: from commandSender
        String arguments = Joiner.on(' ').join(strings); // TODO: ?

        try {
            Optional<CommandResult> commandResult = commandMapping.getCallable().process(commandSource, arguments);

            return commandResult.isPresent(); // TODO
        } catch (CommandException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
