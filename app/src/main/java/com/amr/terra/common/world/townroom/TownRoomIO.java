package com.amr.terra.common.world.townroom;

import com.amr.terra.data.Point;
import com.amr.terra.io.BinaryReader;
import java.io.IOException;

public class TownRoomIO {

  public static TownRoom[] read(BinaryReader br) throws IOException {
    final int count = br.readInt32();
    final TownRoom[] rooms = new TownRoom[count];
    for (int i = 0; i < count; i++) {
      final int npcId = br.readInt32();
      final Point pos = new Point(br.readInt32(), br.readInt32());
      rooms[i] = new TownRoom(npcId, pos);
    }
    return rooms;
  }
}
