package com.amr.terra.data;

import java.util.Objects;

public class Dimen {
  private final int w;
  private final int h;

  public Dimen(int w, int h) { this.w = w; this.h = h; }

  public int getWidth() { return w; }
  public int getHeight() { return h; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dimen dimen = (Dimen) o;
    return w == dimen.w && h == dimen.h;
  }

  @Override public int hashCode() { return Objects.hash(w, h); }
  @Override public String toString() { return "Dimen(w=" + w + ", h=" + h + ")"; }
}
