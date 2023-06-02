package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private final String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException("name can't be null");
    } else {
      this.name = name;
    }
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    ItemImpl other1 = (ItemImpl) other;
    return name.equals(other1.getName());
  }

  @Override
  public String toString() {
    return name;
  }
}
