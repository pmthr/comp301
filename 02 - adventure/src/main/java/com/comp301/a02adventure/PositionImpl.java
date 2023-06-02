package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    switch (direction) {
      case EAST:
        return new PositionImpl(getX() + 1, getY());
      case WEST:
        return new PositionImpl(getX() - 1, getY());
      case NORTH:
        return new PositionImpl(getX(), getY() + 1);
      case SOUTH:
        return new PositionImpl(getX(), getY() - 1);
    }
    return new PositionImpl(getX(), getY());
  }
}
