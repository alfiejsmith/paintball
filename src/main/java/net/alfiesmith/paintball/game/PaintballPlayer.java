package net.alfiesmith.paintball.game;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class PaintballPlayer {

  private final UUID uuid;

  public Player getPlayer() {
    return Bukkit.getPlayer(uuid);
  }

}
