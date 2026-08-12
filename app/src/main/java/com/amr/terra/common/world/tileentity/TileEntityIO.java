package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Item;
import com.amr.terra.data.Point;
import com.amr.terra.io.BinaryReader;
import java.io.IOException;

public class TileEntityIO {

  public static TileEntity[] read(BinaryReader br, int v) throws IOException {
    final int count = br.readInt32();
    final TileEntity[] entities = new TileEntity[count];

    for (int i = 0; i < count; i++) {
      final int typeId = br.readUByte();
      br.readInt32(); // entity ID - assigned at runtime, not needed
      final Point pos = new Point(br.readInt16(), br.readInt16());
      entities[i] = readExtra(br, v, typeId, pos);
    }

    return entities;
  }

  private static TileEntity readExtra(BinaryReader br, int v, int typeId, Point pos) throws IOException {
    final TileEntityType type = TileEntityType.fromId(typeId);

    switch (type) {
      case TRAINING_DUMMY: return readDummy(br, pos);
      case ITEM_FRAME:     return readItemFrame(br, pos);
      case LOGIC_SENSOR:   return readLogicSensor(br, pos);
      case DISPLAY_DOLL:   return readDisplayDoll(br, v, pos);
      case WEAPONS_RACK:   return readWeaponsRack(br, pos);
      case HAT_RACK:       return readHatRack(br, pos);
      case FOOD_PLATTER:   return readFoodPlatter(br, pos);
      case TELEPORT_PYLON: return new TeleportPylon(pos);
      case DEAD_CELLS_JAR: return readDeadCellsJar(br, pos);
      case CRITTER_ANCHOR: return readLeashedAnchor(br, TileEntityType.CRITTER_ANCHOR, pos);
      case KITE_ANCHOR:    return readLeashedAnchor(br, TileEntityType.KITE_ANCHOR, pos);
      default:             return new TileEntity(null, pos); // unknown type
    }
  }

  // --- Individual Readers ---

  private static TrainingDummy readDummy(BinaryReader br, Point pos) throws IOException {
    return new TrainingDummy(pos, br.readInt16());
  }

  private static ItemFrame readItemFrame(BinaryReader br, Point pos) throws IOException {
    return new ItemFrame(pos, readItem(br));
  }

  private static LogicSensor readLogicSensor(BinaryReader br, Point pos) throws IOException {
    final LogicSensor.CheckType checkType = LogicSensor.CheckType.fromId(br.readUByte());
    final boolean isOn = br.readBoolean();
    return new LogicSensor(pos, checkType, isOn);
  }

  private static DisplayDoll readDisplayDoll(BinaryReader br, int v, Point pos) throws IOException {
    final int equipMask = br.readUByte();
    final int dyeMask   = br.readUByte();

    final byte pose = v >= 307 ? (byte) br.readUByte() : 0;

    int miscMask = 0;
    if (v >= 308) miscMask = br.readUByte();

    // v311 had a bug where bit 1 of miscMask was used incorrectly
    boolean equip8flag = (miscMask & 2) != 0;
    boolean dye8flag   = (miscMask & 4) != 0;
    boolean misc0flag  = (miscMask & 1) != 0;
    if (v == 311) equip8flag = false; // ReLogic patched this out

    final int fullEquipMask = equipMask | (equip8flag ? 256 : 0);
    final int fullDyeMask   = dyeMask   | (dye8flag   ? 256 : 0);

    final Item[] equip = new Item[9];
    for (int i = 0; i < 9; i++)
      equip[i] = (fullEquipMask & (1 << i)) != 0 ? readItem(br) : null;

    final Item[] dyes = new Item[9];
    for (int i = 0; i < 9; i++)
      dyes[i] = (fullDyeMask & (1 << i)) != 0 ? readItem(br) : null;

    final Item[] misc = new Item[1];
    misc[0] = misc0flag ? readItem(br) : null;

    return new DisplayDoll(pos, equip, dyes, misc, pose);
  }

  private static WeaponsRack readWeaponsRack(BinaryReader br, Point pos) throws IOException {
    return new WeaponsRack(pos, readItem(br));
  }

  private static HatRack readHatRack(BinaryReader br, Point pos) throws IOException {
    final int mask = br.readUByte();
    // bits: 0=item[0], 1=item[1], 2=dye[0], 3=dye[1]
    final Item[] items = new Item[2];
    final Item[] dyes  = new Item[2];
    for (int i = 0; i < 2; i++)
      items[i] = (mask & (1 << i)) != 0 ? readItem(br) : null;
    for (int i = 0; i < 2; i++)
      dyes[i] = (mask & (1 << (i + 2))) != 0 ? readItem(br) : null;
    return new HatRack(pos, items, dyes);
  }

  private static FoodPlatter readFoodPlatter(BinaryReader br, Point pos) throws IOException {
    return new FoodPlatter(pos, readItem(br));
  }

  private static LeashedAnchor readLeashedAnchor(BinaryReader br, TileEntityType type, Point pos) throws IOException {
    return new LeashedAnchor(type, pos, br.readInt16());
  }

  private static DeadCellsJar readDeadCellsJar(BinaryReader br, Point pos) throws IOException {
    return new DeadCellsJar(pos, readItem(br));
  }

  // Shared item reader - used by multiple TE types
  private static Item readItem(BinaryReader br) throws IOException {
    final Item item =
    new Item(
        br.readInt16(),
        br.readUByte(),
        br.readInt16());
    return item;
  }
}
