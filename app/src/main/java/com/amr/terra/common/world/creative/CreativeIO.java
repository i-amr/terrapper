package com.amr.terra.common.world.creative;

import com.amr.terra.io.BinaryReader;
import java.io.IOException;

public class CreativeIO {

  public static Creative read(BinaryReader br) throws IOException {

    final Creative creative = new Creative();

      while (br.readBoolean()) {
        final int powerId = br.readInt16();

        switch (powerId) {
          case Creative.POWER_ID_TIME_LOCKED   : creative.setTimeLocked(br.readBoolean()); break;
          case Creative.POWER_ID_GODMODE       : creative.setGodMode(br.readBoolean()); break;
          case Creative.POWER_ID_TIME_RATE     : creative.setTimeRate(br.readSingle()); break;
          case Creative.POWER_ID_RAIN_LOCKED   : creative.setRainLocked(br.readBoolean()); break;
          case Creative.POWER_ID_WIND_LOCKED   : creative.setWindLocked(br.readBoolean()); break;
          case Creative.POWER_ID_EXTEND_RANGE  : creative.setExtendedRange(br.readBoolean()); break;
          case Creative.POWER_ID_DIFFICULTY    : creative.setDifficulty(br.readSingle()); break;
          case Creative.POWER_ID_SPREAD_LOCKED : creative.setBiomeSpread(!br.readBoolean()); break;
          case Creative.POWER_ID_SPAWN_RATE    : creative.setSpawnRate(br.readSingle()); break;
        }
      }
    return creative;
  }
}
