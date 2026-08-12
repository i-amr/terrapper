package com.amr.terra.common.world.chest;

import com.amr.terra.data.Item;
import com.amr.terra.data.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Chest {

  public static final int DEFAULT_MAX_ITEMS = 40;
  public static final int MAX_NAME_LENGTH = 20;

  public static final int MAX_ITEMS = DEFAULT_MAX_ITEMS;

  private List<Item> items = new ArrayList<>();
  private Point point;
  private String label;
  private int slotCount;

  protected Chest() { }
  public Chest(String label, Point point, int slotCount) {
    this.label = label;
    this.point = point;
    this.slotCount = slotCount;
  }

  public String getLabel() { return label; }
  public void setLabel(String label) { this.label = label; }

  public Point getPoint() { return point; }
  public void setPoint(Point point) { this.point = point; }
  public void setPoint(int x, int y) { this.point = new Point(x, y); }

  public int getSlotCount() { return slotCount; }
  public void setSlotCount(int slotCount) { this.slotCount = slotCount; }

  public List<Item> getItems() { return items; }
  public void setItems(List<Item> items) { this.items = items; }

  public Item getItem(int idx) {
    if (items == null || idx < 0 || idx >= items.size()) return null;
    return items.get(idx);
  }

  public void setItem(int idx, Item item) {
    if (items != null && idx >= 0 && idx < items.size())
        items.set(idx, item);
  }

  public void addItem(Item item) {
    if (items != null) items.add(item);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Chest chest = (Chest) o;
    return Objects.equals(label, chest.label) && 
        point.equals(chest.point) && slotCount == chest.slotCount;
  }

  @Override public int hashCode() {
    return Objects.hash(label, point, slotCount);
  }

  @Override
  public String toString() {
    return "Chest(" +
        "label=" + label +
        ", point=" + point +
        ", slotCount=" + slotCount +
        ", items=" + Arrays.toString(items.toArray()) +
        ')';
  }
}
