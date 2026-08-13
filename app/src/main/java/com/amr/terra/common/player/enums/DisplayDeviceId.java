package com.amr.terra.common.player.enums;

public enum DisplayDeviceId {
  TIME,
  WEATHER,
  FISHING,
  POSITION,
  DEPTH,
  CREATURE_COUNT,
  KILL_COUNT,
  MOON_PHASE,
  UNDEFINED,
  MOVEMENT_SPEED,
  TREASURE,
  RARE_CREATURES,
  DAMAGE_PER_SECOND;

  public int value() { return ordinal(); }
  public static int length() { return values().length; }

  public static DisplayDeviceId fromInt(int v) {
    for (DisplayDeviceId device : values())
      if (v == device.value()) return device;
    return TIME;
  }
}
