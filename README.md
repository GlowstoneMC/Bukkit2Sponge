Bukkit2Sponge
=============

An implementation of [SpongeAPI](https://github.com/SpongePowered/SpongeAPI) as a Bukkit plugin.

[![Build Status](https://circleci.com/gh/GlowstonePlusPlus/Bukkit2Sponge/tree/master.png)](https://circleci.com/gh/GlowstonePlusPlus/Bukkit2Sponge/tree/master)

Bukkit2Sponge allows loading SpongeAPI plugins on Bukkit servers.

* [Bukkit2Sponge thread on Sponge Forums](https://forums.spongepowered.org/t/bukkit2sponge-an-implementation-of-spongeapi-for-bukkit-servers/6747)
* [Bukkit2Sponge resource on SpigotMC](http://www.spigotmc.org/resources/bukkit2sponge.6368/)

Warning: very incomplete (bug reports and pull requests appreciated, see [issues](https://github.com/GlowstonePlusPlus/Bukkit2Sponge/issues))

Usage
-----

Copy the plugin jar to the `plugins` directory of your Bukkit server.

Run your server, the first time it will create a `plugins/Bukkit2Sponge/plugins` directory.
You can place your SpongeAPI plugins here.

If using the [Glowstone++](https://github.com/GlowstonePlusPlus/GlowstonePlusPlus)
server, you can alternatively place the SpongeAPI plugins in the top-level `plugins/` directory
and they will be loaded by Bukkit2Sponge as well (requires build 226+).

When starting the server, if configured correctly Bukkit2Sponge should log the SpongeAPI plugins it finds:

```
17:52:00 [INFO] [Bukkit2Sponge] Loading plugins...
17:52:00 [INFO] [Bukkit2Sponge] Initializing 1 SpongeAPI plugins...
```

Downloads
---------

Latest builds are available from:

* **[Latest development builds](https://circleci.com/gh/GlowstonePlusPlus/Bukkit2Sponge/tree/master)** - click the latest build then expand "Artifacts" (if it does not show, try logging in with GitHub)
[![Build Status](https://circleci.com/gh/GlowstonePlusPlus/Bukkit2Sponge/tree/master.png)](https://circleci.com/gh/GlowstonePlusPlus/Bukkit2Sponge/tree/master)
* Releases also available on [Bukkit2Sponge resource on SpigotMC](http://www.spigotmc.org/resources/bukkit2sponge.6368/)


Building from source
--------------------

1.  After installing the
[Java Development Kit](http://oracle.com/technetwork/java/javase/downloads) and
[Maven](https://maven.apache.org), checkout the source:

```
git clone --recursive https://github.com/GlowstonePlusPlus/Bukkit2Sponge
cd Bukkit2Sponge
```

2. Build and install the APIs:

```
cd SpongeAPI
./gradlew
cd ..
```

3. Build the plugin:

```
mvn package
```

The plugin jar will be placed in `target/`.


See also
--------

* [Sponge](https://github.com/SpongePowered/Sponge): SpongeAPI implementation on Minecraft Forge
* [SpongeVanilla](https://github.com/SpongePowered/SpongeVanilla): SpongeAPI implementation on Minecraft
* [Pore](https://github.com/LapisBlue/Pore): a SpongeAPI plugin to load Bukkit plugins (the opposite of Bukkit2Sponge)

License
-------

Bukkit2Sponge is open-source software released under the MIT license. Please see
the `LICENSE` file for details.

Bukkit is open-source software released under the GPL license. Please see
the `LICENSE.txt` file in the Bukkit repository for details.

