package io.github.deathcap.bukkit2sponge.event;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.event.callback.CallbackList;

/**
 * A base class for defining events.
 */
public class BaseEvent implements Event {

    private final CallbackList callbacks = new CallbackList();

    public BaseEvent() {
    }

    @Override
    public CallbackList getCallbacks() {
        return callbacks;
    }

    @Override
    public Cause getCause() {
        return null;
    }
}
