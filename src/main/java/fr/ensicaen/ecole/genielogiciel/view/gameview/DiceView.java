package fr.ensicaen.ecole.genielogiciel.view.gameview;

import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import javafx.animation.RotateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.util.Duration;

public class DiceView extends VBox {
    private final StackPane _diceRectangle;
    private final Text _diceText;
    private final IGamePresenter _gamePresenter;

    public DiceView(IGamePresenter gamePresenter) {
        setPadding(new Insets(10));
        setSpacing(10);
        setAlignment(Pos.CENTER);
        setMinWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);

        _gamePresenter = gamePresenter;

        Button diceButton = new Button("Roll Dice");
        diceButton.setOnAction(actionEvent -> handleButtonRollDice());
        VBox.setMargin(diceButton, new Insets(0, 0, 10, 0));

        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);
        _diceRectangle = new StackPane();
        Rectangle rectangle = new Rectangle(50, 50);
        _diceText = new Text("0");
        _diceText.setFill(Color.color(1, 1, 1));
        _diceText.setTextAlignment(TextAlignment.CENTER);
        _diceText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        _diceRectangle.getChildren().addAll(
                rectangle,
                _diceText
        );
        pane.getChildren().add(_diceRectangle);

        getChildren().addAll(
                diceButton,
                pane
        );
    }

    public void updateDice(int diceValue) {
        _diceText.setText(String.valueOf(diceValue));
    }

    public void handleButtonRollDice() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), _diceRectangle);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setOnFinished(event -> _gamePresenter.runGameTurn());
        rotateTransition.play();
    }
}
