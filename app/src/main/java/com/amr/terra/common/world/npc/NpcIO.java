package com.amr.terra.common.world.npc;

import com.amr.terra.io.BinaryReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NpcIO {

  public static Npc[] read(BinaryReader br, int v) throws IOException {
    final List<Npc> npcs = new ArrayList<>();
    final int shimmeredCount = br.readInt32();
    final int[] shimmered = new int[shimmeredCount];

    for (int i = 0; i < shimmeredCount; i++) shimmered[i] = br.readInt32();

    while (br.readBoolean()) {
      final Npc npc = new Npc();
      npc.setId(br.readInt32());
      npc.setName(br.readString());
      npc.setPoint((int) br.readSingle(), (int) br.readSingle());
      npc.setHomeless(br.readBoolean());
      npc.setHomePoint(br.readInt32(), br.readInt32());
      npc.setShimmered(IntStream.of(shimmered).anyMatch(id -> id == npc.getId()));

      if ((br.readUByte() & 1) != 0) npc.setVariationIndex(br.readInt32());

      if (v >= 315) npc.setDespawnIfHomeless(br.readBoolean());

      npcs.add(npc);
    }

    while (br.readBoolean()) {
      final Npc npc = new Npc();
      npc.setId(br.readInt32());
      npc.setPoint((int) br.readSingle(), (int) br.readSingle());
      npcs.add(npc);
    }

    return npcs.toArray(new Npc[0]);
  }
}
