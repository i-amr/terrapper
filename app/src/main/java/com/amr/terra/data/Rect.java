package com.amr.terra.data;

import java.util.Objects;

public class Rect {
  private int left, right, top, bottom;

  public Rect(int left, int right, int top, int bottom) {
    this.left = left;
    this.right = right;
    this.top = top;
    this.bottom = bottom;
  }

  public int getLeft() { return left; }
  public int getRight() { return right; }
  public int getTop() { return top; }
  public int getBottom() { return bottom; }

  public void setLeft(int left) { this.left = left; }
  public void setRight(int right) { this.right = right; }
  public void getTop(int top) { this.top = top; }
  public void getBottom(int bottom) { this.bottom = bottom; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Rect rect = (Rect) o;
    return left == rect.left && right == rect.right && top == rect.top && bottom == rect.bottom;
  }

  @Override public int hashCode() { return Objects.hash(left, right, top, bottom); }
  @Override public String toString() { return "Rect(left=" + left + ", right=" + right + ", top=" + top + ", bottom=" + bottom + ')'; }
}
