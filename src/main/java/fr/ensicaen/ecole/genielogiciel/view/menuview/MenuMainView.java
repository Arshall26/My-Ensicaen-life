package fr.ensicaen.ecole.genielogiciel.view.menuview;

import fr.ensicaen.ecole.genielogiciel.presenter.GamePresenter;
import fr.ensicaen.ecole.genielogiciel.view.WidgetUtils;
import fr.ensicaen.ecole.genielogiciel.view.gameview.GameView;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MenuMainView extends VBox {
    private final int _minPlayers = 2;
    private final int _maxPlayers = 5;
    private final VBox _playerList;
    private int _nPlayers = 0;
    private Button _playButton = null;
    private final Stage _stage;

    public MenuMainView(Stage primaryStage) {
        setSpacing(10);
        setAlignment(Pos.TOP_CENTER);

        _stage = primaryStage;

        HBox gameTitle = WidgetUtils.textRow("My Ensicaen Life", 24);

        Button addPlayerButton = new Button("Add Player");
        addPlayerButton.setOnAction(event -> addNewPlayer());

        _playerList = new VBox();
        _playerList.setAlignment(Pos.CENTER);
        _playerList.setSpacing(10);

        getChildren().addAll(
                gameTitle,
                addPlayerButton,
                _playerList
        );

        // Add 2 initial entries
        for (int i = 0; i < 2; ++i) {
            addNewPlayer();
        }
    }

    public void removePlayButton() {
        getChildren().remove(_playButton);
        _playButton = null;
    }

    public void addPlayButton() {
        _playButton = new Button("Start the Game");
        _playButton.setOnAction(event -> startGame());
        getChildren().add(_playButton);
    }

    public void deletePlayer(MenuPlayerView player) {
        _playerList.getChildren().remove(player);
        if (--_nPlayers < _minPlayers) {
            removePlayButton();
        } else if (_playButton == null && _nPlayers <= _maxPlayers) {
            addPlayButton();
        }
    }

    public void addNewPlayer() {
        _playerList.getChildren().add(new MenuPlayerView(this, ++_nPlayers));
        if (_nPlayers > _maxPlayers) {
            removePlayButton();
        } else if (_playButton == null && _nPlayers >= _minPlayers) {
            addPlayButton();
        }
    }

    public static class ViewPlayer {
        public final String _name;
        public final String _hardSkill;

        ViewPlayer(String name, String hardSkill) {
            _name = name;
            _hardSkill = hardSkill;
        }
    }

    public void startGame() {
        List<ViewPlayer> players = new ArrayList<>();
        for (Node node : _playerList.getChildren()) {
            MenuPlayerView player = (MenuPlayerView) node;
            players.add(new ViewPlayer(player.getName(), player.getHardSkill()));
        }
        // TODO: Let the player choose the board width and height
        // TODO: Or maybe propose different pre-configured board layouts
        int width = 8;
        int height = 8;
        GamePresenter presenter = new GamePresenter(players, width, height);
        GameView view = new GameView(_stage, presenter, width, height);
        presenter.setView(view);

        Scene scene = new Scene(view);
        URL path = GameView.class.getResource("Game.css");
        if (path == null) {
            throw new RuntimeException("Can't find CSS file");
        }
        scene.getStylesheets().add(path.toExternalForm());
        _stage.setScene(scene);

    }
}