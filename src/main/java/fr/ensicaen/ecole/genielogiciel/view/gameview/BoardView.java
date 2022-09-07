package fr.ensicaen.ecole.genielogiciel.view.gameview;

import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import fr.ensicaen.ecole.genielogiciel.view.WidgetUtils;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public final class BoardView extends GridPane {
    private final int _width;
    private final int[] _oldSquareID;
    private StackPane[] _pawns;
    private final IGamePresenter _gamePresenter;

    BoardView(IGamePresenter gamePresenter, int width, int height) {
        getStyleClass().add("grid");
        setAlignment(Pos.CENTER);

        _gamePresenter = gamePresenter;
        _width = width;
        _oldSquareID = new int[_gamePresenter.getBoardPresenter().getNumPlayers()];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < _width; ++j) {
                addBoardSquare(i, j);
            }
        }
        addInitialPawns();
    }

    public void addBoardSquare(int row, int col) {
        SquareView view = new SquareView(_gamePresenter, getSquareID(row, col));
        add(view, col, row);
    }

    public void addInitialPawns() {
        _pawns = new StackPane[_gamePresenter.getBoardPresenter().getNumPlayers()];
        for (int i = 0; i < _gamePresenter.getBoardPresenter().getNumPlayers(); ++i) {
            StackPane pawn = WidgetUtils.circleWithText(
                20.0,
                _gamePresenter.getPlayerPresenter().getPlayerByID(i).getPlayerName(),
                Color.color(Math.random(), Math.random(), Math.random())
            );
            pawn.getStyleClass().add("pawn");
            _pawns[i] = pawn;

            updateBoard(i, 0);
        }
    }

    public int getSquareID(int row, int col) {
        return row * _width + col;
    }

    public void addPawn(int playerID, int squareID) {
        Pane oldpane = (Pane) getChildren().get(_oldSquareID[playerID]);
        FlowPane oldsubpane = (FlowPane) oldpane.getChildren().get(1);
        oldsubpane.getChildren().remove(_pawns[playerID]);

        Pane pane = (Pane) getChildren().get(squareID);
        FlowPane subpane = (FlowPane) pane.getChildren().get(1);
        subpane.getChildren().add(_pawns[playerID]);
        _oldSquareID[playerID] = squareID;
    }

    public void updateBoard(int playerID, int squareID) {
        if (squareID == 0) {
            addPawn(playerID, squareID);
            return;
        }
        if (squareID == _oldSquareID[playerID]) {
            return;
        }

        int inc = (squareID < _oldSquareID[playerID]) ? -1 : 1;

        SequentialTransition sequence = new SequentialTransition();
        int i = _oldSquareID[playerID];

        do {
            i += inc;
            int finalI = i;
            KeyFrame keyframe = new KeyFrame(Duration.millis(200), event -> addPawn(playerID, finalI));
            Timeline timeline = new Timeline(keyframe);
            sequence.getChildren().add(timeline);
        } while (i != squareID);

        KeyFrame keyframe = new KeyFrame(Duration.millis(1500));
        Timeline timeline = new Timeline(keyframe);
        sequence.getChildren().add(timeline);
        sequence.play();
    }
}
