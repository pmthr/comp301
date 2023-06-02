package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {
  private final Image image;
  private final int thick;
  private final Color border;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (image == null || thiccness < 0) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.thick = thiccness;
    this.border = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    if (x < thick || x >= image.getWidth() + thick && x < getWidth()) {
      return border;
    }
    if (y < thick || y >= image.getHeight() + thick && y < getHeight()) {
      return border;
    }
    return image.getPixelColor(x - thick, y - thick);
  }

  @Override
  public int getWidth() {
    return image.getWidth() + thick * 2;
  }

  @Override
  public int getHeight() {
    return image.getHeight() + thick * 2;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
