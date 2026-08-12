package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Point;

public class TileEntity {
  protected final TileEntityType type;
  protected final Point position;

  public TileEntity(TileEntityType type, Point position) {
    this.type = type;
    this.position = position;
  }

  public TileEntityType getType() { return type; }
  public Point getPosition() { return position; }

  @Override
  public String toString() {
    return type + " at " + position;
  }
}
