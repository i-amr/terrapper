package com.amr.terra.common.world.sign;

import com.amr.terra.io.BinaryReader;
import java.io.IOException;

public class SignIO {

  public static Sign[] read(BinaryReader br, int v) throws IOException {
    final int signCount = br.readInt16();
    final Sign[] signs = new Sign[signCount];

    for (int i = 0; i < signCount; ++i) {
      signs[i] = new Sign();
      signs[i].setLabel(br.readString());
      signs[i].setPoint(br.readInt32(), br.readInt32());
    }

    return signs;
  }
}
