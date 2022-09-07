package fr.ensicaen.ecole.genielogiciel.view.gameview;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;

public interface IGameView {
    void updateDice(int diceValue);
    void updateBoard(int playerID, int squareID);
    void updateGameMenuView(int playerID);
    void displayWinner(PlayerModel player);
}
