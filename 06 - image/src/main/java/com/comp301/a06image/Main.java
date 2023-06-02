package com.comp301.a06image;

import javafx.application.Application;

import java.awt.*;
import java.io.IOException;

public class Main {

  public static Image makeImage() throws IOException {
    Image pic = new PictureImage("img/kmp.jpg");
    Image red = new BorderDecorator(pic, 5, new Color(255, 0, 0));
    Image blue = new BorderDecorator(red, 50, new Color(0, 0, 255));
    Image c = new CircleDecorator(blue, 50, 50, 40, new Color(255, 255, 0));
    Image s = new SquareDecorator(c, 100, 100, 40, new Color(200, 80, 10));
    Image zoom = new ZoomDecorator(s, 2);
    return zoom;
  }

  public static void main(String[] args) {
    Application.launch(ImageDisplay.class, args);
  }
}
