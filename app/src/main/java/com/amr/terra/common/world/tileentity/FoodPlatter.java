package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Item;
import com.amr.terra.data.Point;

public class FoodPlatter extends TileEntity {
  private final Item item;

  public FoodPlatter(Point position, Item item) {
    super(TileEntityType.FOOD_PLATTER, position);
    this.item = item;
  }

  public Item getItem() { return item; }
}
