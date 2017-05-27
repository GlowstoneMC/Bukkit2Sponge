package net.glowstone.bukkit2sponge;

import com.google.common.base.Optional;
import net.glowstone.bukkit2sponge.command.ShinyConsoleSource;
import org.spongepowered.api.Server;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.profile.GameProfileManager;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.world.ChunkTicketManager;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldArchetype;
import org.spongepowered.api.world.storage.ChunkLayout;
import org.spongepowered.api.world.storage.WorldProperties;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

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
    public java.util.Optional<WorldProperties> getDefaultWorld() {
        return null;
    }

    @Override
    public String getDefaultWorldName() {
        return null;
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
    public WorldProperties createWorldProperties(String folderName, WorldArchetype archetype) throws IOException {
        return null;
    }

    @Override
    public CompletableFuture<java.util.Optional<WorldProperties>> copyWorld(WorldProperties worldProperties, String copyName) {
        return null;
    }

    @Override
    public java.util.Optional<WorldProperties> renameWorld(WorldProperties worldProperties, String newName) {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> deleteWorld(WorldProperties worldProperties) {
        return null;
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
    public java.util.Optional<Scoreboard> getServerScoreboard() {
        return null;
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
    public MessageChannel getBroadcastChannel() {
        return null;
    }

    @Override
    public void setBroadcastChannel(MessageChannel channel) {

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
    public void shutdown() {

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
    public ChunkTicketManager getChunkTicketManager() {
        return null;
    }

    @Override
    public GameProfileManager getGameProfileManager() {
        return null;
    }

    @Override
    public double getTicksPerSecond() {
        return 0;
    }

    @Override
    public java.util.Optional<ResourcePack> getDefaultResourcePack() {
        return null;
    }

    @Override
    public int getPlayerIdleTimeout() {
        return 0;
    }

    @Override
    public void setPlayerIdleTimeout(int timeout) {

    }

    @Override
    public boolean isMainThread() {
        return false;
    }
}
