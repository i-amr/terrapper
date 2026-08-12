package com.amr.terra.common.world.pressureplate;

import com.amr.terra.data.Point;
import java.util.Objects;

public class PressurePlate {
  private final Point position;

  public PressurePlate(Point position) {
    this.position = position;
  }

  public Point getPosition() { return position; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return Objects.equals(position, ((PressurePlate) o).position);
  }

  @Override
  public int hashCode() { return Objects.hash(position); }

  @Override
  public String toString() { return "PressurePlate(" + position + ")"; }
}
