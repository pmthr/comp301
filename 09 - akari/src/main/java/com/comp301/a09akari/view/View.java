package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class View implements FXComponent {
  private final ControllerImpl controller;

  public View(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox view_layout = new VBox();
    view_layout.getStyleClass().add("control-layout");

    ControlsView controlView = new ControlsView(controller);
    view_layout.getChildren().add(controlView.render());

    HeaderView headerView = new HeaderView(controller);
    view_layout.getChildren().add(headerView.render());
    PuzzleView puzzleView = new PuzzleView(controller);
    view_layout.getChildren().add(puzzleView.render());

    MessageView messageView = new MessageView(controller);
    view_layout.getChildren().add(messageView.render());
    view_layout.setPadding(new Insets(10, 10, 10, 10));
    return view_layout;
  }
}
