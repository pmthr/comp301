package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class MessageView implements FXComponent {

  private final ControllerImpl controller;

  public MessageView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    Label solved;

    if (controller.isSolved()) {
      solved = new Label("solved! ✔");
      solved.setTextFill(Color.LIGHTSEAGREEN);
    } else {
      solved = new Label("unsolved ❌");
      solved.setTextFill(Color.MAROON);
    }
    solved.setFont(Font.font("SansSerif", FontWeight.BOLD, FontPosture.ITALIC, 20));

    VBox vBox = new VBox(solved);
    vBox.setAlignment(Pos.TOP_CENTER);
    return vBox;
  }
}
