package com.amr.terra.common.world.npc;

import com.amr.terra.data.Point;
import java.util.Objects;

public class Npc {

  private int id, variationIdx;
  private String name;
  private Point point, homePoint;
  private boolean isHomeless, hasShimmered, mustDespawn;

  protected Npc() { }
  public Npc(
    int id,
    String name,
    Point point,
    Point homePoint,
    boolean isHomeless,
    boolean hasShimmered,
    boolean mustDespawn,
    int variationIdx
  ) {
    this.id = id;
    this.name = name;
    this.point = point;
    this.homePoint = homePoint;
    this.isHomeless = isHomeless;
    this.hasShimmered = hasShimmered;
    this.mustDespawn = mustDespawn;
    this.variationIdx = variationIdx;
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public Point getPoint() { return point; }
  public void setPoint(Point point) { this.point = point; }
  public void setPoint(int x, int y) { this.point = new Point(x, y); }

  public Point getHomePoint() { return homePoint; }
  public void setHomePoint(Point point) { this.homePoint = point; }
  public void setHomePoint(int x, int y) { this.homePoint = new Point(x, y); }

  public boolean mustDespawn() { return mustDespawn; }
  public void setDespawnIfHomeless(boolean mustDespawn) { this.mustDespawn = mustDespawn; }

  public boolean isHomeless() { return isHomeless; }
  public void setHomeless(boolean isHomeless) { this.isHomeless = isHomeless; }

  public boolean hasShimmered() { return hasShimmered; }
  public void setShimmered(boolean hasShimmered) { this.hasShimmered = hasShimmered; }

  public int getVariationIndex() { return variationIdx; }
  public void setVariationIndex(int variationIdx) { this.variationIdx = variationIdx; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Npc npc = (Npc) o;
    return id == npc.id &&
        Objects.equals(name, npc.name) &&
        point.equals(npc.point) &&
        homePoint.equals(npc.homePoint) &&
        isHomeless == npc.isHomeless &&
        hasShimmered == npc.hasShimmered &&
        mustDespawn == npc.mustDespawn &&
        variationIdx == npc.variationIdx;
  }

  @Override public int hashCode() {
    return Objects.hash(id, name, point, homePoint, isHomeless, hasShimmered, mustDespawn, variationIdx);
  }

  @Override
  public String toString() {
    return "Npc(" +
        "id=" + id +
        ", name=\"" + name + '"' +
        ", point=" + point +
        ", homePoint=" + homePoint +
        ", isHomeless=" + isHomeless +
        ", hasShimmered=" + hasShimmered +
        ", mustDespawn=" + mustDespawn +
        ", variationIdx=" + variationIdx +
        ')';
  }
}
