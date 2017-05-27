package net.glowstone.bukkit2sponge.event;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.Cause;

/**
 * A base class for defining events.
 */
public class BaseEvent implements Event {
    public BaseEvent() {
    }

    @Override
    public Cause getCause() {
        return null;
    }
}
