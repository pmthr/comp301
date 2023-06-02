package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {
  private final Image image;
  private final int sx;
  private final int sy;
  private final int size;
  private final Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (image == null || squareSize < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.sx = squareX;
    this.sy = squareY;
    this.size = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if ((sx <= x && x < (size + sx)) && (sy <= y && y < (size + sy))) {
      return color;
    }
    return image.getPixelColor(x, y);
  }

  @Override
  public int getWidth() {
    return image.getWidth();
  }

  @Override
  public int getHeight() {
    return image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
