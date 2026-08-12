package com.amr.terra.enums;

public enum TeamId {
  NONE,
  RED,
  GREEN,
  BLUE,
  YELLOW,
  PURPLE;

  public int value() { return ordinal(); }
  public static int length() { return values().length; }

  public static TeamId fromInt(int v) {
    for (TeamId team : values())
      if (v == team.value()) return team;
    return NONE;
  }
}
