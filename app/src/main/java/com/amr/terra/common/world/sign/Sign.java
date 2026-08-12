package com.amr.terra.common.world.sign;

import com.amr.terra.data.Point;
import java.util.Objects;

public class Sign {

  public static final int MAX_SIGNS = 32000;

  private Point point;
  private String label;

  protected Sign() { }
  public Sign(String label, Point point) {
    this.label = label;
    this.point = point;
  }

  public String getLabel() { return label; }
  public void setLabel(String label) { this.label = label; }

  public Point getPoint() { return point; }
  public void setPoint(Point point) { this.point = point; }
  public void setPoint(int x, int y) { this.point = new Point(x, y); }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Sign sign = (Sign) o;
    return Objects.equals(label, sign.label) && 
        point.equals(sign.point);
  }

  @Override public int hashCode() {
    return Objects.hash(label, point);
  }

  @Override
  public String toString() {
    return "Sign(" +
        "label=" + label +
        ", point=" + point +
        ')';
  }
}
