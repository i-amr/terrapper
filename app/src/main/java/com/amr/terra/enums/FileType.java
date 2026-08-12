package com.amr.terra.enums;

public enum FileType {
  NONE,   // corrupted or smth
  MAP,    // .map
  WORLD,  // .wld
  PLAYER; // .plr

  public int value() { return ordinal(); }
  public static int length() { return values().length; }

  public static FileType fromInt(int v) {
    for (FileType type : values())
      if (v == type.value()) return type;
    return NONE;
  }
}
