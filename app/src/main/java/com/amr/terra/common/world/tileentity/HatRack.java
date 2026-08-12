package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Item;
import com.amr.terra.data.Point;

public class HatRack extends TileEntity {
  private final Item[] items; // 2 slots
  private final Item[] dyes;  // 2 slots

  public HatRack(Point position, Item[] items, Item[] dyes) {
    super(TileEntityType.HAT_RACK, position);
    this.items = items;
    this.dyes  = dyes;
  }

  public Item[] getItems() { return items; }
  public Item[] getDyes()  { return dyes; }
}
