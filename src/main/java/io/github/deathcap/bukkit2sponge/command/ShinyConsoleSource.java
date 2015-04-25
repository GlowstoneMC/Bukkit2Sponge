package io.github.deathcap.bukkit2sponge.command;

import io.github.deathcap.bukkit2sponge.permission.ShinySubject;
import org.spongepowered.api.service.permission.context.Context;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.source.ConsoleSource;

import java.util.Set;

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
         for (Text message : messages) {
            System.out.println("ShinyConsoleSource sendMessage: " + Texts.toPlain(message));
        }
    }

    @Override
    public void sendMessage(Iterable<Text> messages) {
        for (Text message : messages) {
            System.out.println("ShinyConsoleSource sendMessage: " + Texts.toPlain(message));
        }
    }

    // org.spongepowered.api.service.permission.Subject
    @Override
    public boolean hasPermission(String permission) {
        return true; // console has all permissions
    }
}
