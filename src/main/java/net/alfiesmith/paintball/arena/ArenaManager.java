package net.alfiesmith.paintball.arena;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;

public class ArenaManager {

  private int currentId = 0;
  private final Int2ObjectMap<Arena> arenas;

  public ArenaManager() {
    this.arenas = Int2ObjectMaps.synchronize(new Int2ObjectArrayMap<>());
  }

  public Arena createArena(String name) {
    Arena arena = new Arena(currentId++);
    this.arenas.put(arena.getId(), arena);
    return arena;
  }

  public Arena getArena(int id) {
    return arenas.get(id);
  }

  public Arena getArena(String name) {
    return arenas.values().stream().filter(arena -> arena.getName().equals(name)).findFirst()
        .orElse(null);
  }


}
