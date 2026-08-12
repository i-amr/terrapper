package com.amr.terra.data;

import java.util.Objects;

public class Spawn {
  private int id;
  private String name;
  private Point point;

  public Spawn() { }
  public Spawn(int id, String name, Point point) { this.id = id; this.name = name; this.point = point; }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public Point getPoint() { return point; }
  public void setPoint(Point point) { this.point = point; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Spawn spawn = (Spawn) o;
    return id == spawn.id && Objects.equals(name, spawn.name) && Objects.equals(point, spawn.point);
  }

  @Override public int hashCode() { return Objects.hash(id, name, point); }
  @Override public String toString() { return "Spawn(id=" + id + ", name=" + name + ", point=" + point + ")"; }
}
