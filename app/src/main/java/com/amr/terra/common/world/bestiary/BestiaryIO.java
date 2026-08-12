package com.amr.terra.common.world.bestiary;

import android.util.Pair;
import com.amr.terra.io.BinaryReader;
import java.io.IOException;
import java.util.List;

public class BestiaryIO {

  public static Bestiary read(BinaryReader br) throws IOException {

    final Bestiary bestiary = new Bestiary();
    final List<Pair<String, Integer>> kills = bestiary.getKills();
    final List<String> sights = bestiary.getSights();
    final List<String> chats = bestiary.getChats();

    final int killCount = br.readInt32();
    for (int i = 0; i < killCount; i++) kills.add(new Pair<>(br.readString(), br.readInt32()));

    final int sightCount = br.readInt32();
    for (int i = 0; i < sightCount; i++) sights.add(br.readString());

    final int chatCount = br.readInt32();
    for (int i = 0; i < chatCount; i++) chats.add(br.readString());

    return bestiary;
  }
}
