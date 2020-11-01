package net.alfiesmith.paintball.arena;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import net.alfiesmith.paintball.Paintball;
import net.alfiesmith.paintball.game.PaintballTeam;
import org.bukkit.Location;

public class Arena {

  @Getter
  private final int id;

  @Getter
  @Setter
  private String name, description, author;

  private final Multimap<PaintballTeam, Location> spawnLocations;

  protected Arena(int id) {
    this.id = id;
    this.name = "New Arena";
    this.description = "";
    this.author = "Unknown";
    this.spawnLocations = ArrayListMultimap.create();
  }

  public int getNumberOfTeams() {
    return this.spawnLocations.keySet().size();
  }

  public int getTeamSize() {
    return this.spawnLocations.values().size() / this.spawnLocations.keySet().size();
  }

  public int getTotalPlayers() {
    return this.spawnLocations.asMap().values().stream().mapToInt(Collection::size).sum();
  }

  public void addSpawnLocation(PaintballTeam team, Location location) {
    this.spawnLocations.put(team, location);
  }

  public void removeSpawnLocation(PaintballTeam team, Location location) {
    this.spawnLocations.remove(team, location);
  }

  public void clearSpawnLocation(PaintballTeam team) {
    this.spawnLocations.removeAll(team);
  }

  public Collection<Location> getSpawnLocations(PaintballTeam team) {
    return this.spawnLocations.get(team);
  }

}
