package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private final String name;
  private final Inventory inventory = new InventoryImpl();
  private Position position;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException("name can't be null");
    } else {
      this.name = name;
    }
    position = new PositionImpl(startX, startY);
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Inventory getInventory() {
    return inventory;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void move(Direction direction) {
    position =
        new PositionImpl(
            position.getNeighbor(direction).getX(), position.getNeighbor(direction).getY());
  }
}
