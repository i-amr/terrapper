package com.amr.terra.common.world.chest;

import com.amr.terra.data.Item;
import com.amr.terra.io.BinaryReader;
import java.io.IOException;

public class ChestIO {

  public static Chest[] read(BinaryReader br, int v) throws IOException {
    final int chestCount = br.readInt16();
    final Chest[] chests = new Chest[chestCount];

    final int globalSlots = v < 294 ? br.readInt16() : 0;

    for (int i = 0; i < chestCount; i++) {
      chests[i] = new Chest();
      chests[i].setPoint(br.readInt32(), br.readInt32());
      chests[i].setLabel(br.readString());

      final int slotCount = v >= 294 ? br.readInt32() : globalSlots;
      final int slotsToRead = v >= 294 ? slotCount : Math.min(slotCount, Chest.MAX_ITEMS);
      final int slotsToSkip = v >= 294 ? 0 : Math.max(0, slotCount - Chest.MAX_ITEMS);

      for (int slot = 0; slot < slotsToRead; slot++) {
        final short stackSize = br.readInt16();
        final Item item = new Item();
        if (stackSize != 0) {
          item.setId(br.readInt32());
          item.setPrefix(br.readUByte());
          item.setStackSize(stackSize > (short) 0 ? stackSize : 1);
        }
        chests[i].addItem(item);
      }

      for (int slot = 0; slot < slotsToSkip; slot++) {
        if (br.readInt16() > 0) {
          br.readInt32();
          br.readUByte();
        }
      }
    }

    return chests;
  }
}
