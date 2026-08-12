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
        "time="              + displayDevice[DisplayDeviceId.TIME.value()] +
        ", weather="         + displayDevice[DisplayDeviceId.WEATHER.value()] +
        ", fishing="         + displayDevice[DisplayDeviceId.FISHING.value()] +
        ", position="        + displayDevice[DisplayDeviceId.POSITION.value()] +
        ", depth="           + displayDevice[DisplayDeviceId.DEPTH.value()] +
        ", creatureCount="   + displayDevice[DisplayDeviceId.CREATURE_COUNT.value()] +
        ", killCount="       + displayDevice[DisplayDeviceId.KILL_COUNT.value()] +
        ", moonPhase="       + displayDevice[DisplayDeviceId.MOON_PHASE.value()] +
        ", movementSpeed="   + displayDevice[DisplayDeviceId.MOVEMENT_SPEED.value()] +
        ", treasure="        + displayDevice[DisplayDeviceId.TREASURE.value()] +
        ", rareCreatures="   + displayDevice[DisplayDeviceId.RARE_CREATURES.value()] +
        ", damagePerSecond=" + displayDevice[DisplayDeviceId.DAMAGE_PER_SECOND.value()] +
        ')';
  }
}
