package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.effect.EffectNone;
import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;
import fr.ensicaen.ecole.genielogiciel.model.SquareModel;
import fr.ensicaen.ecole.genielogiciel.view.gameview.IGameView;

public final class BoardPresenter implements IBoardPresenter {
    public final int _boardSize;
    private final ISquareModel[] _squares;
    private IGameView _gameView;
    private final int _nPlayers;
    private int _numberExam = 0;
    private int _numberRedoublement = 0;
    private IPlayerPresenter _playerPresenter;

    public BoardPresenter(int n_players, int width, int height) {
        _boardSize = width * height;
        _squares = new ISquareModel[_boardSize];
        _nPlayers = n_players;
        generateRandomBoard();
    }

    public void generateRandomBoard(){
        for (int i = 0; i < _boardSize-1; ++i) {
            _squares[i] = SquareModel.randomSquare(i);
            if(_numberExam >= 2){
                while(_squares[i].getSpeciality() == ISquareModel.Speciality.Examen){
                    _squares[i] = SquareModel.randomSquare(i);
                }
            }
            if(_numberRedoublement >= 2){
                while(_squares[i].getSpeciality() == ISquareModel.Speciality.Redoublement){
                    _squares[i] = SquareModel.randomSquare(i);
                }
            }
            if(_squares[i].getSpeciality() == ISquareModel.Speciality.Examen){
                _numberExam += 1;
            }
            if(_squares[i].getSpeciality() == ISquareModel.Speciality.Redoublement){
                _numberRedoublement += 1;
            }
        }
        _squares[_boardSize-1]= new SquareModel(_boardSize-1, ISquareModel.Speciality.Diplome, new EffectNone());
    }

    public void setPlayerPresenter(IPlayerPresenter playerPresenter) {
        _playerPresenter = playerPresenter;
    }

    public int getNumPlayers() {
        return _nPlayers;
    }

    public int getBoardSize() {
        return _boardSize;
    }

    public void setView(IGameView view) {
        _gameView = view;
    }

    public ISquareModel getPlayerNewSquare(PlayerModel player, int diceValue) {
        int newSquareID;
        ISquareModel oldSquare = player.getSquare();
        int sum = oldSquare.getSquareID() + diceValue;

        if (sum < 0) {
            newSquareID = 0;
        } else if (sum < _boardSize) {
            newSquareID = sum;
        } else {
            newSquareID = (_boardSize-1) - (sum - (_boardSize-1));
        }
        return _squares[newSquareID];
    }

    public void movePlayerToNewSquare(PlayerModel player, int diceValue) {
        ISquareModel newSquare = getPlayerNewSquare(player, diceValue);
        ISquareModel oldSquare = player.getSquare();

        PlayerModel playerCollision = _playerPresenter.checkPlayerCollision(newSquare);

        player.setSquare(newSquare);
        _gameView.updateBoard(player.getPlayerID(), newSquare.getSquareID());

        if (playerCollision != null) {
            int squareId = oldSquare.getSquareID();
            playerCollision.setSquare(oldSquare);
            _gameView.updateBoard(playerCollision.getPlayerID(), squareId);
        }
    }

    public void newSquareEffect(PlayerModel player) {
        SquareModel newSquare = (SquareModel) player.getSquare();
        boolean replayEffect = false;

        int squareBonus = newSquare.effect(player);
        // Update the SkillLevel display
        _gameView.updateGameMenuView(player.getPlayerID());

        if (squareBonus != 0) {
            movePlayerToNewSquare(player, squareBonus);
            // Effect is not triggered if we go back
            if (squareBonus > 0) {
                replayEffect = true;
            }
        }

        int hardSkillBonus = player.getHardSkillBonus(newSquare);
        if (hardSkillBonus != 0) {
            movePlayerToNewSquare(player, hardSkillBonus);
            if (hardSkillBonus > 0) {
                replayEffect = true;
            }
        }

        if (replayEffect) {
            newSquareEffect(player);
        }
    }

    public void movePlayer(PlayerModel player, int diceValue){
        diceValue += player.getSoftSkillBonus();
        movePlayerToNewSquare(player, diceValue);
        newSquareEffect(player);
    }

    public ISquareModel getSquareByID(int id) {
        return _squares[id];
    }
}