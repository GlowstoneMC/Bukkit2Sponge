package io.github.deathcap.bukkit2sponge.permission;

import com.google.common.base.Optional;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.SubjectCollection;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.command.CommandSource;

import java.util.List;
import java.util.Set;

public class ShinySubject implements Subject {
    private String identifier;

    public ShinySubject(String identifier)
    {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public Optional<CommandSource> getCommandSource() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SubjectCollection getContainingCollection() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SubjectData getSubjectData() {
        return null;
    }

    @Override
    public SubjectData getTransientSubjectData() {
        return null;
    }

    @Override
    public SubjectData getData() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SubjectData getTransientData() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasPermission(Set<Context> contexts, String permission) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasPermission(String permission) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Tristate getPermissionValue(Set<Context> contexts, String permission) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChildOf(Subject parent) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChildOf(Set<Context> contexts, Subject parent) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Subject> getParents() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Subject> getParents(Set<Context> contexts) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Context> getActiveContexts() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
