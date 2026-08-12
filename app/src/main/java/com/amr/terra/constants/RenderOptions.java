package com.amr.terra.constants;

public class RenderOptions {
  public static final int BACKGROUNDS = 1;
  public static final int WALLS = 2;
  public static final int LIQUIDS = 4;
  public static final int BLOCKS = 8;
  public static final int WIRES = 16;
  public static final int PAINTS = 32;
  public static final int CRACKED = 64;
  public static final int ALL = BACKGROUNDS | WALLS | LIQUIDS | BLOCKS | WIRES | PAINTS | CRACKED;
}
