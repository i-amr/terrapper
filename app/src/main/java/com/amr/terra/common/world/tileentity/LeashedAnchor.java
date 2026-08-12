package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Point;

public class LeashedAnchor extends TileEntity {
  private final int itemType; // 0 if empty

  public LeashedAnchor(TileEntityType type, Point position, int itemType) {
    super(type, position);
    this.itemType = itemType;
  }

  public int getItemType() { return itemType; }
}
