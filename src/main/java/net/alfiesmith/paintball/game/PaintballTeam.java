package net.alfiesmith.paintball.game;

import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Snowball;

public enum PaintballTeam {

  RED(SmallFireball.class),
  BLUE(Snowball.class),
  YELLOW(Egg.class),
  GREEN(EnderPearl.class);

  private final Class<? extends Projectile> projectileClass;

  PaintballTeam(Class<? extends Projectile> projectileClass) {
    this.projectileClass = projectileClass;
  }

}
