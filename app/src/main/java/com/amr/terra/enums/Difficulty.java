package com.amr.terra.enums;

public enum Difficulty {
  CLASSIC, // NORMAL
  EXPERT,  // MEDIUMCORE
  MASTER,  // HARDCORE
  JOURNEY; // CREATIVE

  public int value() { return ordinal(); }
  public static int length() { return values().length; }

  public static Difficulty fromInt(int v) {
    for (Difficulty mode : values())
      if (v == mode.value()) return mode;
    return CLASSIC;
  }
}
