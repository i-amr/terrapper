package com.amr.terra.common.player.data;

import com.amr.terra.common.player.enums.DisplayDeviceId;
import java.util.Objects;

public class DisplayDevice {

  private boolean[] displayDevice = new boolean[DisplayDeviceId.length()];

  public boolean isEnabled(DisplayDeviceId device) { return device != null && displayDevice[device.value()]; }
  public void setEnabled(DisplayDeviceId device, boolean enabled) { if (device != null) this.displayDevice[device.value()] = enabled; }

  public boolean isEnabled(int id) { return id >= 0 && id < DisplayDeviceId.length() && displayDevice[id]; }
  public void setEnabled(int id, boolean enabled) { if (id >= 0 && id < DisplayDeviceId.length()) this.displayDevice[id] = enabled; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DisplayDevice device = (DisplayDevice) o;
    return displayDevice == device.displayDevice;
  }

  @Override public int hashCode() {
    return Objects.hash(displayDevice);
  }

  @Override
  public String toString() {
    return "DisplayDevice("  +
        "movementSpeed="     + isEnabled(DisplayDeviceId.MOVEMENT_SPEED) +
        ", position="        + isEnabled(DisplayDeviceId.POSITION) +
        ", depth="           + isEnabled(DisplayDeviceId.DEPTH) +
        ", creatureCount="   + isEnabled(DisplayDeviceId.CREATURE_COUNT) +
        ", killCount="       + isEnabled(DisplayDeviceId.KILL_COUNT) +
        ", damagePerSecond=" + isEnabled(DisplayDeviceId.DAMAGE_PER_SECOND) +
        ", fishing="         + isEnabled(DisplayDeviceId.FISHING) +
        ", treasure="        + isEnabled(DisplayDeviceId.TREASURE) +
        ", rareCreatures="   + isEnabled(DisplayDeviceId.RARE_CREATURES) +
        ", time="            + isEnabled(DisplayDeviceId.TIME) +
        ", weather="         + isEnabled(DisplayDeviceId.WEATHER) +
        ", moonPhase="       + isEnabled(DisplayDeviceId.MOON_PHASE) +
        // ", undefined="       + isEnabled(DisplayDeviceId.UNDEFINED) +
        ')';
  }
}
