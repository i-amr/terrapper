package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Item;
import com.amr.terra.data.Point;

public class DisplayDoll extends TileEntity {
  private final Item[] equip; // 9 slots
  private final Item[] dyes;  // 9 slots
  private final Item[] misc;  // 1 slot (weapon)
  private final byte pose;

  public DisplayDoll(Point position, Item[] equip, Item[] dyes, Item[] misc, byte pose) {
    super(TileEntityType.DISPLAY_DOLL, position);
    this.equip = equip;
    this.dyes  = dyes;
    this.misc  = misc;
    this.pose  = pose;
  }

  public Item[] getEquip() { return equip; }
  public Item[] getDyes()  { return dyes; }
  public Item[] getMisc()  { return misc; }
  public byte getPose()    { return pose; }
}
