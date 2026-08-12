package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Item;
import com.amr.terra.data.Point;

public class ItemFrame extends TileEntity {
  private final Item item;

  public ItemFrame(Point position, Item item) {
    super(TileEntityType.ITEM_FRAME, position);
    this.item = item;
  }

  public Item getItem() { return item; }
}
