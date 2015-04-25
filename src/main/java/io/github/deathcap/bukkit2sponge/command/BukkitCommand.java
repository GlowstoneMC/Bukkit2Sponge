package io.github.deathcap.bukkit2sponge.command;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.*;

import java.util.ArrayList;

public class BukkitCommand extends Command {

    private CommandMapping commandMapping;
    private static ShinyConsoleSource commandSource = new ShinyConsoleSource("console"); // TODO

    public BukkitCommand(CommandMapping commandMapping) {
        super(commandMapping.getPrimaryAlias(),
                getDescription(commandMapping),
                getUsage(commandMapping),
                new ArrayList<>(commandMapping.getAllAliases())); // TODO: remove primary alias?

        this.commandMapping = commandMapping;
    }

    private static String getDescription(CommandMapping commandMapping) {
        Optional<Text> textOptional = commandMapping.getCallable().getShortDescription(commandSource);;
        if (!textOptional.isPresent()) {
            return commandMapping.getPrimaryAlias();
        }

        return spongeTextToString(textOptional.get());
    }

    private static String spongeTextToString(Text text) {
        try {
            return Texts.toPlain(text);
        } catch (NullPointerException ex) {
            // Incomplete part of SpongeAPI? null factory
            // https://github.com/SpongePowered/SpongeAPI/commit/38acf16861b99c76c8df23f8fceabe896217318b#commitcomment-10900228
            if (text instanceof Text.Literal) {
                return ((Text.Literal) text).getContent();
            }
            return text.toString();
        }
    }

    private static String getUsage(CommandMapping commandMapping) {
        Text text = commandMapping.getCallable().getUsage(commandSource);;

        return spongeTextToString(text);
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
