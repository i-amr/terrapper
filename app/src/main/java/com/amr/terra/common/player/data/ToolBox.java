package com.amr.terra.common.player.data;

import com.amr.terra.common.player.enums.ToolBoxId;
import java.util.Objects;

public class ToolBox {

  private int[] tools = new int[ToolBoxId.length()];

  // public boolean get(int id) { return id >= 0 && id < ToolBoxId.length() && tools[id]; }
  // public void set(int id, int itemId) { if (id >= 0 && id < ToolBoxId.length()) this.displayDevice[id] = enabled; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    // ToolBox device = (ToolBox) o;
    return false;//displayDevice == device.displayDevice;
  }

  @Override public int hashCode() {
    return Objects.hash("oh no");
  }

  @Override
  public String toString() {
    return "ToolBox("  +
        // "movementSpeed="     + isEnabled(ToolBoxId.MOVEMENT_SPEED) +
        // ", position="        + isEnabled(ToolBoxId.POSITION) +
        // ", depth="           + isEnabled(ToolBoxId.DEPTH) +
        // ", creatureCount="   + isEnabled(ToolBoxId.CREATURE_COUNT) +
        // ", killCount="       + isEnabled(ToolBoxId.KILL_COUNT) +
        // ", damagePerSecond=" + isEnabled(ToolBoxId.DAMAGE_PER_SECOND) +
        // ", fishing="         + isEnabled(ToolBoxId.FISHING) +
        // ", treasure="        + isEnabled(ToolBoxId.TREASURE) +
        // ", rareCreatures="   + isEnabled(ToolBoxId.RARE_CREATURES) +
        // ", time="            + isEnabled(ToolBoxId.TIME) +
        // ", weather="         + isEnabled(ToolBoxId.WEATHER) +
        // ", moonPhase="       + isEnabled(ToolBoxId.MOON_PHASE) +
        // ", undefined="       + isEnabled(ToolBoxId.UNDEFINED) +
        ')';
  }
}
