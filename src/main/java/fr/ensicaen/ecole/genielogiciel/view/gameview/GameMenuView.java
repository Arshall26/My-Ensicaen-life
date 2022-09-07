package fr.ensicaen.ecole.genielogiciel.view.gameview;

import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class GameMenuView extends VBox {
    private final DiceView _diceView;
    private final PlayersView _playersView;

    GameMenuView(IGamePresenter gamePresenter) {
        setSpacing(10);
        setAlignment(Pos.CENTER);

        _diceView = new DiceView(gamePresenter);
        _playersView = new PlayersView(gamePresenter);

        getChildren().addAll(
            _diceView,
            _playersView
        );
    }

    public void updateDice(int diceValue) {
        _diceView.updateDice(diceValue);
    }

    public void updateGameMenuView(int playerID) {
        _playersView.updatePlayersView(playerID);
    }
}
