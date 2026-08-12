package com.amr.terra.data;

import java.util.Objects;

public class Color {
  private int a, r, g, b;

  public Color(int r, int g, int b) { this(255, r, g, b); }
  public Color(int a, int r, int g, int b) { setAlpha(a); setRed(r); setGreen(g); setBlue(b); }

  public int getAlpha()       { return a & 255; }
  public void setAlpha(int a) { this.a = a; }
  public int getRed()         { return r & 255; }
  public void setRed(int r)   { this.r = r; }
  public int getGreen()       { return g & 255; }
  public void setGreen(int g) { this.g = g; }
  public int getBlue()        { return b & 255; }
  public void setBlue(int b)  { this.b = b; }

  public int toInteger()      { return a << 24 | r << 16 | g << 8 | b; }
  public String toHexString() { return toHexString(false); }
  public String toHexString(boolean withAlpha) {
    return withAlpha
        ? String.format("#%02X%02X%02X%02X", a, r, g, b)
        : String.format("#%02X%02X%02X", r, g, b);
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Color cls = (Color) o;
    return a == cls.a && r == cls.r && g == cls.g && b == cls.b;
  }
  @Override public int hashCode() { return Objects.hash(a + r + g + b); }
  @Override public String toString() { return String.format("Color(a=%d, r=%d, g=%d, b=%d)", a, r, g, b); }
}