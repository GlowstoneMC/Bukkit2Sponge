package net.glowstone.bukkit2sponge.command;

import net.glowstone.bukkit2sponge.permission.ShinySubject;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;

public class ShinyConsoleSource extends ShinySubject implements ConsoleSource {
    public ShinyConsoleSource(String identifier) {
        super(identifier);
    }

    @Override
    public String getName() {
        return this.getIdentifier();
    }

    // org.spongepowered.api.service.permission.Subject
    @Override
    public boolean hasPermission(String permission) {
        return true; // console has all permissions
    }

    @Override
    public void sendMessage(Text message) {

    }

    @Override
    public MessageChannel getMessageChannel() {
        return null;
    }

    @Override
    public void setMessageChannel(MessageChannel channel) {

    }
}
