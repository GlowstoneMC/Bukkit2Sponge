package net.glowstone.bukkit2sponge.event;

import org.spongepowered.api.event.*;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link EventManager}.
 */
public class ShinyEventManager implements EventManager {

    private final Map<Order, List<EventRegistration>> registrations = new EnumMap<>(Order.class);

    public ShinyEventManager() {
        for (Order order : Order.values()) {
            registrations.put(order, new LinkedList<EventRegistration>());
        }
    }

    @Override
    public void registerListeners(Object plugin, Object obj) {

    }

    @Override
    public <T extends Event> void registerListener(Object plugin, Class<T> eventClass, EventListener<? super T> listener) {

    }

    @Override
    public <T extends Event> void registerListener(Object plugin, Class<T> eventClass, Order order, EventListener<? super T> listener) {

    }

    @Override
    public <T extends Event> void registerListener(Object plugin, Class<T> eventClass, Order order, boolean beforeModifications, EventListener<? super T> listener) {

    }

    @Override
    public void unregisterListeners(Object obj) {

    }

    @Override
    public void unregisterPluginListeners(Object plugin) {

    }

    @Override
    public boolean post(Event event) {
        for (List<EventRegistration> list : registrations.values()) {
            for (EventRegistration reg : list) {
                reg.call(event);
            }
        }
        return !(event instanceof Cancellable) || ((Cancellable) event).isCancelled();
    }

    public void callSpecial(Object target, Event event) {
        for (List<EventRegistration> list : registrations.values()) {
            for (EventRegistration reg : list) {
                if (reg.getObject() == target) {
                    reg.call(event);
                }
            }
        }
    }
}
