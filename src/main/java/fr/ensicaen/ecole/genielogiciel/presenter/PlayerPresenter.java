package fr.ensicaen.ecole.genielogiciel.presenter;


import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;
import fr.ensicaen.ecole.genielogiciel.model.player.PlayerFactory;
import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.view.menuview.MenuMainView;

import java.util.List;

public class PlayerPresenter implements  IPlayerPresenter {
    private final PlayerModel[] _players;
    private final int _n_players;
    private int _player_turn = 0;

    public PlayerPresenter(ISquareModel firstSquare, List<MenuMainView.ViewPlayer> players) {
        _n_players = players.size();
        _players = new PlayerModel[_n_players];
        for (int i = 0; i < _n_players; ++i) {
            MenuMainView.ViewPlayer player = players.get(i);
            _players[i] = PlayerFactory.createPlayer(i, player._name, player._hardSkill, firstSquare);
        }
    }

    public PlayerModel playerTurn() {
        if (_player_turn == _n_players) {
            _player_turn = 0;
        }
        if (_players[_player_turn].getSkipTurn()) {
            _players[_player_turn].setSkipTurn(false);
            ++_player_turn;
        }
        if (_player_turn == _n_players) {
            _player_turn = 0;
        }
        return _players[_player_turn++];
    }

    public PlayerModel getPlayerByID(int id) {
        return _players[id];
    }

    public PlayerModel[] getAllPlayers() {
        return _players;
    }

    public PlayerModel checkPlayerCollision(ISquareModel newSquare) {
        for (int i = 0; i < _n_players; ++i) {
            if (_players[i].getSquare() == newSquare) {
                return _players[i];
            }
        }
        return null;
    }
}