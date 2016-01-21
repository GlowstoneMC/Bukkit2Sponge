package io.github.deathcap.bukkit2sponge.command;

import io.github.deathcap.bukkit2sponge.permission.ShinySubject;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.text.channel.MessageChannel;

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
            System.out.println("ShinyConsoleSource sendMessage: " + Text.of(message).toPlain());
        }
    }

    @Override
    public void sendMessage(Iterable<Text> messages) {
        for (Text message : messages) {
            System.out.println("ShinyConsoleSource sendMessage: " + Text.of(message).toPlain());
        }
    }

    // org.spongepowered.api.service.permission.Subject
    @Override
    public boolean hasPermission(String permission) {
        return true; // console has all permissions
    }

    @Override
    public void sendMessage(Text text) {

    }

    @Override
    public MessageChannel getMessageChannel() {
        return null;
    }

    @Override
    public void setMessageChannel(MessageChannel messageChannel) {

    }
}
