package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Point;

public class TrainingDummy extends TileEntity {
  private final int npcIndex; // -1 if inactive

  public TrainingDummy(Point position, int npcIndex) {
    super(TileEntityType.TRAINING_DUMMY, position);
    this.npcIndex = npcIndex;
  }

  public int getNpcIndex() { return npcIndex; }
}
