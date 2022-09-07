package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;
import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.view.gameview.IGameView;

public interface IBoardPresenter {
    void setView(IGameView view);
    ISquareModel getSquareByID(int id);
    int getBoardSize();
    int getNumPlayers();
    void movePlayer(PlayerModel player, int diceValue);
    void setPlayerPresenter(IPlayerPresenter playerPresenter);
}

