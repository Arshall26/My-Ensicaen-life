package fr.ensicaen.ecole.genielogiciel.view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;

public class WidgetUtils {
    public static StackPane circleWithText(double radius, String text, Color color) {
        StackPane stackpane = new StackPane();
        Circle circle = new Circle(radius);
        circle.setFill(color);
        circle.setStroke(Color.valueOf("white"));
        circle.setStrokeWidth(4.0);
        Text t = new Text(text);
        stackpane.getChildren().addAll(
                circle,
                t
        );
        return stackpane;
    }

    public static HBox textRow(String content, double fontSize) {
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);
        Text text = new Text(content);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, fontSize));
        pane.getChildren().add(text);
        return pane;
    }
}
