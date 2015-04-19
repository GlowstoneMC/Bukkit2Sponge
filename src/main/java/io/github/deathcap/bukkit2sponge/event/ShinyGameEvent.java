package io.github.deathcap.bukkit2sponge.event;

import com.google.common.base.Optional;
import io.github.deathcap.bukkit2sponge.Bukkit2Sponge;
import org.bukkit.event.Cancellable;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.CauseTracked;

public class ShinyGameEvent extends BaseEvent implements GameEvent, Cancellable, CauseTracked {

    private boolean cancelled = false;

    public Game getGame() {
        return Bukkit2Sponge.instance.getGame();
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public Optional<Cause> getCause() {
        return Optional.absent();
    }
}
