package net.alfiesmith.paintball.game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaintballGame {

  private final Map<PaintballTeam, PaintballPlayer> players;

  public PaintballGame() {
    this.players = new ConcurrentHashMap<>();
  }
}
