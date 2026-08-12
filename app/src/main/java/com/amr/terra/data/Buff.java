package com.amr.terra.data;

import com.amr.terra.enums.BuffId;
import java.util.Objects;

public class Buff {
  private int id, duration;

  public Buff() { }
  public Buff(BuffId id, int duration) { this(id.value(), duration); }
  public Buff(int id, int duration) {
    this.id = id;
    this.duration = duration;
  }

  public int getId() { return id; }
  public void setId(BuffId id) { setId(id.value()); }
  public void setId(int id) { this.id = id >= BuffId.length() ? BuffId.NONE.value() : id; }

  public int getDuration() { return duration; }
  public void setDuration(int duration) { this.duration = duration; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Buff buff = (Buff) o;
    return id == buff.id;
  }

  @Override public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Buff(" +
        "id=" + id +
        ", duration=" + duration +
        ')';
  }
}
