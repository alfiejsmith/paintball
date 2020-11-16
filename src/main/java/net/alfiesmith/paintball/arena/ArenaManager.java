package net.alfiesmith.paintball.arena;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import java.awt.geom.Area;
import java.io.File;
import java.io.IOException;
import net.alfiesmith.paintball.Paintball;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ArenaManager {

  private final Paintball plugin;

  private final File arenaFile;
  private final FileConfiguration arenaConfig;

  private int currentId = 0;
  private final Int2ObjectMap<Arena> arenas;

  public ArenaManager(Paintball plugin) throws IOException {
    this.plugin = plugin;
    this.arenas = Int2ObjectMaps.synchronize(new Int2ObjectArrayMap<>());

    this.arenaFile = new File(plugin.getDataFolder(), "arena.yml");
    if (!this.arenaFile.exists()) {
      this.arenaFile.getParentFile().mkdirs();
      this.arenaFile.createNewFile();
    }
    this.arenaConfig = YamlConfiguration.loadConfiguration(this.arenaFile);

  }

  public Arena createArena(String name) {
    Arena arena = new Arena(currentId++);
    this.arenas.put(arena.getId(), arena);
    return arena;
  }

  public Arena loadArena(String name) {
    Arena arena = createArena(name);

    // TODO: Load arena details here from config

    return arena;
  }

  public void saveArena(Arena arena) throws IOException {

    this.arenaConfig.set(arena.getName(), null);

    ConfigurationSection section = this.arenaConfig.createSection(arena.getName());
    section.set("name", arena.getName());
    section.set("number-of-teams", arena.getNumberOfTeams()); // TODO: Change for team colors..

    if (arena.getDescription() != null) {
      this.arenaConfig.set("description", arena.getDescription());
    }

    if (arena.getAuthor() != null) {
      this.arenaConfig.set("author", arena.getAuthor());
    }

    this.arenaConfig.save(this.arenaFile);
  }

  public Arena getArena(int id) {
    return arenas.get(id);
  }

  public Arena getArena(String name) {
    return arenas.values().stream().filter(arena -> arena.getName().equals(name)).findFirst()
        .orElse(null);
  }


}
