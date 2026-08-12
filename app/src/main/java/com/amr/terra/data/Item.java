package com.amr.terra.data;

import com.amr.terra.enums.ItemId;
import java.util.Objects;

public class Item {
  public static final int MAX_STACK = 9999;

  private int id, prefix, stack;
  private boolean pinned;

  public Item() { }
  public Item(ItemId id, int prefix) { this(id, prefix, 1); }
  public Item(ItemId id, int prefix, int stack) { this(id, prefix, stack, false); }
  public Item(ItemId id, int prefix, int stack, boolean pinned) { this(id.value(), prefix, stack, pinned); }
  public Item(int id, int prefix) { this(id, prefix, 1); }
  public Item(int id, int prefix, int stack) { this(id, prefix, stack, false); }
  public Item(int id, int prefix, int stack, boolean pinned) {
    this.id = id;
    this.prefix = prefix;
    this.stack = stack;
    this.pinned = pinned;
  }

  public int getId() { return id; }
  public void setId(int id) { this.id = id >= ItemId.length() ? ItemId.NONE.value() : id; }

  public int getPrefix() { return prefix; }
  public void setPrefix(int prefix) { this.prefix = prefix; }

  public int getStackSize() { return stack; }
  public void setStackSize(int stack) { this.stack = stack; }

  public boolean isPinned() { return pinned; }
  public void setPinned(boolean pinned) { this.pinned = pinned; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return id == item.id &&
         prefix == item.prefix;
  }

  @Override public int hashCode() {
    return Objects.hash(id, prefix, stack);
  }

  @Override
  public String toString() {
    return "Item(" +
        "id=" + id +
        ", prefix=" + prefix +
        ", stack=" + stack +
        ", pinned=" + pinned +
        ')';
  }
}
