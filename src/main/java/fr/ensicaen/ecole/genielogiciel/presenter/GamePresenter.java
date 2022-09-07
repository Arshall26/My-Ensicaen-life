package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.DiceModel;
import fr.ensicaen.ecole.genielogiciel.model.IDiceModel;
import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.view.gameview.IGameView;
import fr.ensicaen.ecole.genielogiciel.view.menuview.MenuMainView;

import java.util.List;

public class GamePresenter implements IGamePresenter {
    private final IDiceModel _diceModel;
    private final IBoardPresenter _boardPresenter;
    private final IPlayerPresenter _playerPresenter;
    private final ISalaryPresenter _salaryPresenter;
    private IGameView _gameView;

    public GamePresenter(List<MenuMainView.ViewPlayer> players, int width, int height) {
        _diceModel = new DiceModel();
        _boardPresenter = new BoardPresenter(players.size(), width, height);
        _playerPresenter = new PlayerPresenter(_boardPresenter.getSquareByID(0), players);
        _boardPresenter.setPlayerPresenter(_playerPresenter);
        _salaryPresenter = new SalaryPresenter();
    }

    public void setView(IGameView gameView) {
        _gameView = gameView;
        _boardPresenter.setView(gameView);
    }

    public IBoardPresenter getBoardPresenter() {
        return _boardPresenter;
    }

    public IPlayerPresenter getPlayerPresenter() {
        return _playerPresenter;
    }

    public ISalaryPresenter getSalaryPresenter() {
        return _salaryPresenter;
    }

    public void runGameTurn() {
        // Who's turn is it
        PlayerModel thrower = _playerPresenter.playerTurn();

        int diceValue = _diceModel.roll();
        // TODO: Pass the player soft skill to display it
        _gameView.updateDice(diceValue);

        _boardPresenter.movePlayer(thrower, diceValue);

        // If player won
        if (thrower.getSquare().getSquareID() == _boardPresenter.getBoardSize()-1) {
            _gameView.displayWinner(thrower);
        }
    }
}