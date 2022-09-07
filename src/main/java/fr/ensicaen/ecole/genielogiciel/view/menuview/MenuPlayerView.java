package fr.ensicaen.ecole.genielogiciel.view.menuview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;

public class MenuPlayerView extends GridPane {
    private final TextField _playerNameField;
    private final ChoiceBox<String> _cbHardSkills;

    MenuPlayerView(MenuMainView menuMainView, int n_player) {
        setAlignment(Pos.CENTER);
        setHgap(20);

        _playerNameField = new TextField("Player " + n_player);
        _playerNameField.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        ObservableList<String> hardSkills = FXCollections.observableArrayList("Prepa", "DUT", "Licence");
        _cbHardSkills = new ChoiceBox<>(hardSkills);
        _cbHardSkills.setValue("Prepa");

        Button deletePlayerButton = new Button("Delete Player");
        deletePlayerButton.setOnAction(event -> menuMainView.deletePlayer(this));

        add(new Text("Name"), 0, 0);
        add(_playerNameField, 0, 1);
        add(new Text("Hard Skill"), 1, 0);
        add(_cbHardSkills, 1, 1);
        add(deletePlayerButton, 2, 1);
    }

    public String getName() {
        return _playerNameField.getText();
    }

    public String getHardSkill() {
        return _cbHardSkills.getValue();
    }
}
