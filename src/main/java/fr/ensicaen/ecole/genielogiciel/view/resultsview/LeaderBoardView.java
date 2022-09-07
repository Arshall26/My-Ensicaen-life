package fr.ensicaen.ecole.genielogiciel.view.resultsview;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Arrays;

public class LeaderBoardView extends GridPane {
    public LeaderBoardView(IGamePresenter gamePresenter) {
        getStyleClass().add("leaderboard");

        setHgap(10);
        setVgap(10);
        setPadding(new Insets(5));
        setAlignment(Pos.CENTER);

        add(new Text("Position"), 0, 0);
        add(new Text("Player"), 1, 0);
        add(new Text("Square Number"), 2, 0);

        PlayerModel[] players = gamePresenter.getPlayerPresenter().getAllPlayers().clone();
        Arrays.sort(players, (o1, o2) -> {
            Integer i1 = o1.getSquare().getSquareID();
            Integer i2 = o2.getSquare().getSquareID();
            return i2.compareTo(i1);
        });

        for (int i = 1; i <= players.length; ++i) {
            PlayerModel player = players[i-1];
            add(new Text(String.valueOf(i)), 0, i);
            add(new Text(player.getPlayerUsername()), 1, i);
            add(new Text(String.valueOf(player.getSquare().getSquareID()+1)), 2, i);
        }

        Arrays.sort(players, (o1, o2) -> {
            Float s1 = gamePresenter.getSalaryPresenter().computePlayerSalary(players, o1);
            Float s2 = gamePresenter.getSalaryPresenter().computePlayerSalary(players, o2);
            return s2.compareTo(s1);
        });
    }
}
