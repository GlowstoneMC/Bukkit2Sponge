package io.github.deathcap.bukkit2sponge;

import com.google.common.base.Optional;
import io.github.deathcap.bukkit2sponge.command.ShinyConsoleSource;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.net.ChannelListener;
import org.spongepowered.api.net.ChannelRegistrationException;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.source.ConsoleSource;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldCreationSettings;
import org.spongepowered.api.world.storage.ChunkLayout;
import org.spongepowered.api.world.storage.WorldProperties;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class ShinyServer implements Server {

    private org.bukkit.Server handle;
    private ShinyConsoleSource consoleSource = new ShinyConsoleSource("console");

    public ShinyServer(org.bukkit.Server handle) {
        this.handle = handle;
    }

    @Override
    public Collection<Player> getOnlinePlayers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMaxPlayers() {
        return handle.getMaxPlayers();
    }

    @Override
    public Optional<Player> getPlayer(UUID uniqueId) {
        return Optional.absent();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<Player> getPlayer(String name) {
        return Optional.absent();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<World> getWorlds() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<WorldProperties> getUnloadedWorlds() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<WorldProperties> getAllWorldProperties() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<World> getWorld(UUID uniqueId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<World> getWorld(String worldName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<World> loadWorld(String worldName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<World> loadWorld(UUID uniqueId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<World> loadWorld(WorldProperties properties) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<WorldProperties> getWorldProperties(String worldName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<WorldProperties> getWorldProperties(UUID uniqueId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadWorld(World world) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<WorldProperties> createWorld(WorldCreationSettings settings) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean saveWorldProperties(WorldProperties properties) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ChunkLayout getChunkLayout() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getRunningTimeTicks() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void broadcastMessage(Text message) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Optional<InetSocketAddress> getBoundAddress() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasWhitelist() {
        return handle.hasWhitelist();
    }

    @Override
    public void setHasWhitelist(boolean enabled) {
        handle.setWhitelist(enabled);
    }

    @Override
    public boolean getOnlineMode() {
        return handle.getOnlineMode();
    }

    @Override
    public Text getMotd() {
        return Texts.of(handle.getMotd());
    }

    @Override
    public void shutdown(Text kickMessage) {
        //TODO handle.getShutdownMessage()
        handle.shutdown();
    }

    @Override
    public ConsoleSource getConsole() {
        return consoleSource;
    }

    @Override
    public void registerChannel(Object plugin, ChannelListener listener, String channel) throws ChannelRegistrationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> getRegisteredChannels() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
