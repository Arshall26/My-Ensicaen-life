package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;
import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public interface IPlayerPresenter {
    PlayerModel playerTurn();
    PlayerModel getPlayerByID(int id);
    PlayerModel[] getAllPlayers();
    PlayerModel checkPlayerCollision(ISquareModel newSquare);
}