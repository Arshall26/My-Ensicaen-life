package fr.ensicaen.ecole.genielogiciel.view.resultsview;

import fr.ensicaen.ecole.genielogiciel.model.player.PlayerModel;
import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ResultsView extends VBox {
    public ResultsView(IGamePresenter gamePresenter, PlayerModel winner) {
        setSpacing(20);
        setAlignment(Pos.CENTER);

        Text text = new Text("Player " + (winner.getPlayerID() + 1) + " wins!");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));

        LeaderBoardView leaderBoard = new LeaderBoardView(gamePresenter);
        SalaryBoardView salaryBoard = new SalaryBoardView(gamePresenter);

        getChildren().addAll(
                text,
                leaderBoard,
                salaryBoard
        );
    }
}
