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
  MOVEMENT_SPEED,
  TREASURE,
  RARE_CREATURES,
  DAMAGE_PER_SECOND;
  // MOVEMENT_SPEED,
  // POSITION,
  // DEPTH,
  // CREATURE_COUNT,
  // KILL_COUNT,
  // DAMAGE_PER_SECOND,
  // FISHING,
  // TREASURE,
  // RARE_CREATURES,
  // TIME,
  // WEATHER,
  // MOON_PHASE;

  public int value() { return ordinal(); }
  public static int length() { return values().length; }

  public static DisplayDeviceId fromInt(int v) {
    for (DisplayDeviceId device : values())
      if (v == device.value()) return device;
    return TIME;
  }
}
