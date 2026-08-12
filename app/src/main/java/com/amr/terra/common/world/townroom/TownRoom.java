package com.amr.terra.common.world.townroom;

import com.amr.terra.data.Point;
import java.util.Objects;

public class TownRoom {
  private final int npcId;
  private final Point position;

  public TownRoom(int npcId, Point position) {
    this.npcId    = npcId;
    this.position = position;
  }

  public int getNpcId()      { return npcId; }
  public Point getPosition() { return position; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TownRoom r = (TownRoom) o;
    return npcId == r.npcId && Objects.equals(position, r.position);
  }

  @Override
  public int hashCode() { return Objects.hash(npcId, position); }

  @Override
  public String toString() {
    return "TownRoom(npcId=" + npcId + ", " + position + ")";
  }
}
