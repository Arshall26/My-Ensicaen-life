/*
 * Copyright (c) 2021
 * ENSICAEN, École publique d'ingénieurs et centres de recherche, Caen, FRANCE.
 * https://www.ensicaen.fr
 *
 * This file is owned by ENSICAEN students.
 * No portion of this document may be reproduced, copied
 * or revised without written permission of the authors.
 */

package fr.ensicaen.ecole.genielogiciel.view.gameview;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import fr.ensicaen.ecole.genielogiciel.view.resultsview.ResultsView;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;

public class GameView extends HBox implements IGameView {
    private final BoardView _boardView;
    private final GameMenuView _gameMenuView;
    private final IGamePresenter _gamePresenter;
    private final Stage _stage;

    public GameView(Stage primaryStage, IGamePresenter gamePresenter, int width, int height) {
        _stage = primaryStage;
        _gamePresenter = gamePresenter;
        _gameMenuView = new GameMenuView(_gamePresenter);
        _boardView = new BoardView(_gamePresenter, width, height);

        getChildren().addAll(
            _gameMenuView,
            _boardView
        );
    }

    public void updateDice(int diceValue) {
        _gameMenuView.updateDice(diceValue);
    }

    public void updateBoard(int playerID, int squareID) {
        _boardView.updateBoard(playerID, squareID);
    }

    public void updateGameMenuView(int playerID) {
        _gameMenuView.updateGameMenuView(playerID);
    }

    public void displayWinner(PlayerModel player) {
        Scene scene = new Scene(new ResultsView(_gamePresenter, player));
        URL path = ResultsView.class.getResource("Result.css");
        if (path == null) {
            throw new RuntimeException("Can't find CSS file");
        }
        scene.getStylesheets().add(path.toExternalForm());
        _stage.setScene(scene);
        _stage.setTitle("Winner Board");
    }
}
