package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HeaderView implements FXComponent {
  private final ControllerImpl controller;

  public HeaderView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox layout = new VBox();
    layout.getStylesheets().add("main.css");
    Text title = new Text("akari!");
    Text header =
        new Text(
            "puzzle # "
                + (controller.getActivePuzzleIndex() + 1)
                + " out of "
                + controller.getLibrarySize());
    title.setFont(Font.font("SansSerif", 30));
    title.setLineSpacing(2.0);
    header.setFont(Font.font("SansSerif", 20));

    layout.getChildren().add(title);
    layout.getChildren().add(header);

    layout.setAlignment(Pos.TOP_CENTER);

    return layout;
  }
}
