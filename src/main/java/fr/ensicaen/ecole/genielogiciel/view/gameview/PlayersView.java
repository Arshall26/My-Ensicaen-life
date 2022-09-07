package fr.ensicaen.ecole.genielogiciel.view.gameview;

import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class PlayersView extends VBox {
    private final PlayerView[] _playersView;

    PlayersView(IGamePresenter gamePresenter) {
        setPadding(new Insets(15));
        setSpacing(10);

        int nPlayers = gamePresenter.getBoardPresenter().getNumPlayers();
        _playersView = new PlayerView[nPlayers];

        for (int i = 0; i < nPlayers; ++i) {
            _playersView[i] = new PlayerView(gamePresenter, i);
            getChildren().add(_playersView[i]);
        }
    }

    public void updatePlayersView(int playerID) {
        _playersView[playerID].updatePlayerView(playerID);
    }
}
