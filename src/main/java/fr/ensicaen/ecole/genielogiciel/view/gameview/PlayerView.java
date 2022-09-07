package fr.ensicaen.ecole.genielogiciel.view.gameview;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import fr.ensicaen.ecole.genielogiciel.presenter.IPlayerPresenter;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PlayerView extends GridPane {
    private final IGamePresenter _gamePresenter;
    private final Text _skillLevelText;

    PlayerView(IGamePresenter gamePresenter, int id) {
        getStyleClass().add("player");
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(5));

        _gamePresenter = gamePresenter;

        IPlayerPresenter playerPresenter = gamePresenter.getPlayerPresenter();
        PlayerModel player = playerPresenter.getPlayerByID(id);

        add(createText(player.getPlayerUsername() + " (" + player.getPlayerName() + ")"), 0, 0, 2, 1);
        add(createText("Soft Skill"), 0, 1);
        add(createText(player.getSoftSkillString()), 1, 1);
        add(createText("Hard Skill"), 0, 2);
        add(createText(player.getHardSkillString()), 1, 2);
        add(createText("Skill Level"), 0, 3);

        _skillLevelText = createText("0");
        add(_skillLevelText, 1, 3);
    }

    private Text createText(String s) {
        Text text = new Text(s);
        text.getStyleClass().add("player-cell");
        return text;
    }

    public void updatePlayerView(int playerID) {
        IPlayerPresenter playerPresenter = _gamePresenter.getPlayerPresenter();
        PlayerModel player = playerPresenter.getPlayerByID(playerID);

        _skillLevelText.setText(String.valueOf(player.getSkillLevel()));
    }
}
