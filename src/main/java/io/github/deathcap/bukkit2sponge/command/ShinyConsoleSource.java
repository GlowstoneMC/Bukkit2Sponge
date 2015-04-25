package io.github.deathcap.bukkit2sponge.command;

import io.github.deathcap.bukkit2sponge.permission.ShinySubject;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.command.source.ConsoleSource;

public class ShinyConsoleSource extends ShinySubject implements ConsoleSource {
    public ShinyConsoleSource(String identifier) {
        super(identifier);
    }

    @Override
    public String getName() {
        return this.getIdentifier();
    }

    @Override
    public void sendMessage(Text... messages) {
        System.out.println("ShinyConsoleSource sendMessage: " + messages);
    }

    @Override
    public void sendMessage(Iterable<Text> messages) {
        for (Text message : messages) {
            System.out.println("ShinyConsoleSource sendMessage: " + message);
        }
    }
}
