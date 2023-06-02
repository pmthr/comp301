package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class ControlsView implements FXComponent {
  private final ControllerImpl controller;

  public ControlsView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox controls = new HBox();
    controls.getStyleClass().add("control-layout");
    Button reset = new Button("reset ↻");
    reset.getStyleClass().add("reset-button");
    reset.setFont(Font.font("SansSerif", FontPosture.ITALIC, 20));
    Button previous = new Button("previous ↩");
    previous.getStyleClass().add("previous-button");
    previous.setFont(Font.font("SansSerif", FontPosture.ITALIC, 20));

    Button next = new Button("next ↪");
    next.getStyleClass().add("next-button");
    next.setFont(Font.font("SansSerif", FontPosture.ITALIC, 20));

    Button random = new Button("random \uD83C\uDFB2");
    random.getStyleClass().add("random-button");
    random.setFont(Font.font("SansSerif", FontPosture.ITALIC, 20));

    reset.setOnAction(ActionEvent -> controller.clickResetPuzzle());
    if (controller.getActivePuzzleIndex() == controller.getLibrarySize() - 1) {
      next.setDisable(true);
    } else {
      next.setOnAction(ActionEvent -> controller.clickNextPuzzle());
    }
    if (controller.getActivePuzzleIndex() == 0) {
      previous.setDisable(true);
    } else {
      previous.setOnAction(ActionEvent -> controller.clickPrevPuzzle());
    }
    random.setOnAction(ActionEvent -> controller.clickRandPuzzle());

    controls.getChildren().addAll(reset, previous, next, random);

    return controls;
  }
}
