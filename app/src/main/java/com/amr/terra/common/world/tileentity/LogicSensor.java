package com.amr.terra.common.world.tileentity;

import com.amr.terra.data.Point;

public class LogicSensor extends TileEntity {

  public enum CheckType {
    NONE, DAY, NIGHT, PLAYER_ABOVE, WATER, LAVA, HONEY, LIQUID;

    public static CheckType fromId(int id) {
      CheckType[] v = values();
      return id >= 0 && id < v.length ? v[id] : NONE;
    }
  }

  private final CheckType checkType;
  private final boolean isOn;

  public LogicSensor(Point position, CheckType checkType, boolean isOn) {
    super(TileEntityType.LOGIC_SENSOR, position);
    this.checkType = checkType;
    this.isOn = isOn;
  }

  public CheckType getCheckType() { return checkType; }
  public boolean isOn() { return isOn; }
}
