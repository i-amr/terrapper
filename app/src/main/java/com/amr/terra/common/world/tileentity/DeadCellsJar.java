package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Item;
import com.amr.terra.data.Point;

public class DeadCellsJar extends TileEntity {
  private final Item item;

  public DeadCellsJar(Point position, Item item) {
    super(TileEntityType.DEAD_CELLS_JAR, position);
    this.item = item;
  }

  public Item getItem() { return item; }
}
