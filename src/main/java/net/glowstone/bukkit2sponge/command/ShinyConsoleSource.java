package net.glowstone.bukkit2sponge.command;

import net.glowstone.bukkit2sponge.permission.ShinySubject;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.Tristate;

import java.util.List;
import java.util.Optional;
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
    public SubjectData getSubjectData() {
        return null;
    }

    @Override
    public SubjectData getTransientSubjectData() {
        return null;
    }

    // org.spongepowered.api.service.permission.Subject
    @Override
    public boolean hasPermission(String permission) {
        return true; // console has all permissions
    }

    @Override
    public Tristate getPermissionValue(Set<Context> contexts, String permission) {
        return null;
    }

    @Override
    public boolean isChildOf(Set<Context> contexts, Subject parent) {
        return false;
    }

    @Override
    public List<Subject> getParents(Set<Context> contexts) {
        return null;
    }

    @Override
    public Optional<String> getOption(Set<Context> contexts, String key) {
        return null;
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
