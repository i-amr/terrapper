package com.amr.terra.common.world.pressureplate;

import com.amr.terra.data.Point;
import com.amr.terra.io.BinaryReader;
import java.io.IOException;

public class PressurePlateIO {

  public static PressurePlate[] read(BinaryReader br) throws IOException {
    final int count = br.readInt32();
    final PressurePlate[] plates = new PressurePlate[count];
    for (int i = 0; i < count; i++)
      plates[i] = new PressurePlate(new Point(br.readInt32(), br.readInt32()));
    return plates;
  }
}
