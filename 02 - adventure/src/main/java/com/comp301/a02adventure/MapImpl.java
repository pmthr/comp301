package com.comp301.a02adventure;

public class MapImpl implements Map {

  private final int width;
  private final int height;
  private final Cell[][] grid;
  private final int numItems;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 | height <= 0) {
      throw new IllegalArgumentException("width and height must be positive");
    }
    this.width = width;
    this.height = height;
    this.grid = new Cell[width][height];
    this.numItems = numItems;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (!(x >= 0 && x < width && y >= 0 && y < height)) {
      throw new IndexOutOfBoundsException("coordinate out of map bounds");
    } else {
      return grid[x][y];
    }
  }

  @Override
  public Cell getCell(Position position) {
    return getCell(position.getX(), position.getY());
  }

  @Override
  public void initCell(int x, int y) {
    if (!(x >= 0 && x < width && y >= 0 && y < height)) {
      throw new IndexOutOfBoundsException("coordinate out of map bounds");
    }
    grid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return numItems;
  }
}
