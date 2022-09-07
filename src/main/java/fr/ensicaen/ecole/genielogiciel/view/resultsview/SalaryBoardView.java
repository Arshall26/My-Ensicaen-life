package fr.ensicaen.ecole.genielogiciel.view.resultsview;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import fr.ensicaen.ecole.genielogiciel.presenter.ISalaryPresenter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Arrays;

public class SalaryBoardView extends GridPane {
    public SalaryBoardView(IGamePresenter gamePresenter) {
        getStyleClass().add("leaderboard");

        setHgap(10);
        setVgap(10);
        setPadding(new Insets(5));
        setAlignment(Pos.CENTER);

        add(new Text("Position"), 0, 0);
        add(new Text("Player"), 1, 0);
        add(new Text("Skill Level"), 2, 0);
        add(new Text("Salary"), 3, 0);

        PlayerModel[] players = gamePresenter.getPlayerPresenter().getAllPlayers().clone();

        ISalaryPresenter salaryPresenter = gamePresenter.getSalaryPresenter();
        salaryPresenter.retrieveBaseSalary();

        Arrays.sort(players, (o1, o2) -> {
            Float s1 = salaryPresenter.computePlayerSalary(players, o1);
            Float s2 = salaryPresenter.computePlayerSalary(players, o2);
            return s2.compareTo(s1);
        });

        for (int i = 1; i <= players.length; ++i) {
            PlayerModel player = players[i-1];
            add(new Text(String.valueOf(i)), 0, i);
            add(new Text(player.getPlayerUsername()), 1, i);
            add(new Text(String.valueOf(player.getSkillLevel())), 2, i);
            float salary = gamePresenter.getSalaryPresenter().computePlayerSalary(players, player);
            add(new Text(String.valueOf(salary)), 3, i);
        }
    }
}
