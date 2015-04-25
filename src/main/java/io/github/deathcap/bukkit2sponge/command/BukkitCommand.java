package io.github.deathcap.bukkit2sponge.command;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.*;

import java.util.ArrayList;

public class BukkitCommand extends Command {

    private CommandMapping commandMapping;
    private static ShinyConsoleSource consoleSource = new ShinyConsoleSource("console"); // TODO

    public BukkitCommand(CommandMapping commandMapping) {
        super(commandMapping.getPrimaryAlias(),
                getDescription(commandMapping),
                getUsage(commandMapping),
                new ArrayList<>(commandMapping.getAllAliases())); // TODO: remove primary alias?

        this.commandMapping = commandMapping;
    }

    private static String getDescription(CommandMapping commandMapping) {
        Optional<Text> textOptional = commandMapping.getCallable().getShortDescription(consoleSource);;
        if (!textOptional.isPresent()) {
            return commandMapping.getPrimaryAlias();
        }

        return Texts.toPlain(textOptional.get());
    }

    private static String getUsage(CommandMapping commandMapping) {
        Text text = commandMapping.getCallable().getUsage(consoleSource);;

        return Texts.toPlain(text);
    }

   @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        CommandSource commandSource;

        if (commandSender instanceof ConsoleCommandSender) {
            commandSource = consoleSource;
        } else {
            commandSource = null; // TODO: players, etc.
        }

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
