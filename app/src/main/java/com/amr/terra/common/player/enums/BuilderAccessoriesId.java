package com.amr.terra.common.player.enums;

public enum BuilderAccessoriesId {
  RULER_LINE,                // on | off
  RULER_GRID,                // on | off (mechanical ruler)
  AUTO_ACTUATE,              // on | off (presserator)
  AUTO_PAINT,                // on | off
  WIRE_VISIBILITY_RED,       // bright | classic | faded
  WIRE_VISIBILITY_GREEN,     // bright | classic | faded
  WIRE_VISIBILITY_BLUE,      // bright | classic | faded
  WIRE_VISIBILITY_YELLOW,    // bright | classic | faded
  HIDE_ALL_WIRES,            // on | off
  WIRE_VISIBILITY_ACTUATORS, // bright | classic | faded
  BLOCK_SWAP,                // on | off
  TORCH_BIOME;               // on | off


  public int value() { return ordinal(); }
  public static int length() { return values().length; }

  public static BuilderAccessoriesId fromInt(int v) {
    for (BuilderAccessoriesId tool : values())
      if (v == tool.value()) return tool;
    return RULER_LINE;
  }
}
