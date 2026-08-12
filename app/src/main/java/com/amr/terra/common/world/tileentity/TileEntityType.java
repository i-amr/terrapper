package com.amr.terra.common.world.tileentity;

public enum TileEntityType {
  TRAINING_DUMMY(0),  // TETrainingDummy
  ITEM_FRAME(1),      // TEItemFrame
  LOGIC_SENSOR(2),    // TELogicSensor
  DISPLAY_DOLL(3),    // TEDisplayDoll
  WEAPONS_RACK(4),    // TEWeaponsRack
  HAT_RACK(5),        // TEHatRack
  FOOD_PLATTER(6),    // TEFoodPlatter
  TELEPORT_PYLON(7),  // TETeleportationPylon
  DEAD_CELLS_JAR(8),  // TEDeadCellsDisplayJar
  KITE_ANCHOR(9),     // TEKiteAnchor
  CRITTER_ANCHOR(10); // TECritterAnchor

  public final int id;
  TileEntityType(int id) { this.id = id; }

  public static TileEntityType fromId(int id) {
    for (TileEntityType t : values())
      if (t.id == id) return t;
    return null;
  }
}
