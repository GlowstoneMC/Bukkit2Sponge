package net.glowstone.bukkit2sponge.util;

/**
 * Utilities for throwing UnsupportedOperationExceptions.
 */
public final class Unsupported {

    private Unsupported() {
    }

    public static UnsupportedOperationException missing() {
        return new UnsupportedOperationException("This method is not yet supported.");
    }

}
