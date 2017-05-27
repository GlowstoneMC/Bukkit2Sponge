package net.glowstone.bukkit2sponge.command;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import net.glowstone.bukkit2sponge.Bukkit2Sponge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.ArrayList;

public class BukkitCommand extends Command {

    private CommandMapping commandMapping;

    public BukkitCommand(CommandMapping commandMapping) {
        super(commandMapping.getPrimaryAlias(),
                getDescription(commandMapping),
                getUsage(commandMapping),
                new ArrayList<>(commandMapping.getAllAliases())); // TODO: remove primary alias?

        this.commandMapping = commandMapping;
    }

    private static String getDescription(CommandMapping commandMapping) {
        Optional<Text> textOptional = commandMapping.getCallable().getShortDescription(Bukkit2Sponge.instance.getGame().getServer().getConsole());
        if (!textOptional.isPresent()) {
            return commandMapping.getPrimaryAlias();
        }

        return TextSerializers.PLAIN.serialize(textOptional.get());
    }

    private static String getUsage(CommandMapping commandMapping) {
        Text text = commandMapping.getCallable().getUsage(Bukkit2Sponge.instance.getGame().getServer().getConsole());

        return TextSerializers.PLAIN.serialize(text);
    }

   @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        CommandSource commandSource;

        if (commandSender instanceof ConsoleCommandSender) {
            commandSource = Bukkit2Sponge.instance.getGame().getServer().getConsole();
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
