package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Point;

public class TeleportPylon extends TileEntity {
  public TeleportPylon(Point position) {
    super(TileEntityType.TELEPORT_PYLON, position);
  }
}
