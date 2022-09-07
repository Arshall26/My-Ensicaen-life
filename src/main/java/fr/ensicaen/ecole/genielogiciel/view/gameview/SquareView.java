package fr.ensicaen.ecole.genielogiciel.view.gameview;

import fr.ensicaen.ecole.genielogiciel.model.ISquareModel;
import fr.ensicaen.ecole.genielogiciel.presenter.IGamePresenter;
import fr.ensicaen.ecole.genielogiciel.view.WidgetUtils;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class SquareView extends VBox {
    SquareView(IGamePresenter gamePresenter, int squareID) {
        getStyleClass().add("square");
        setMinWidth(100);
        setMinHeight(100);

        String squareIDStr = String.valueOf(squareID);
        ISquareModel.Speciality squareSpeciality = gamePresenter.getBoardPresenter().getSquareByID(squareID).getSpeciality();
        String[] splits = squareSpeciality.toString().split("_");
        String squareSpecialityStr;
        if (splits.length == 2) {
            squareSpecialityStr = splits[0] + " " + splits[1];
        } else {
            squareSpecialityStr = splits[0];
        }

        HBox pane1 = new HBox(10);
        pane1.setAlignment(Pos.CENTER);
        Text squareText = new Text(squareSpecialityStr);
        squareText.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 11));
        squareText.setTextAlignment(TextAlignment.CENTER);
        pane1.getChildren().addAll(
                WidgetUtils.circleWithText(10.0, squareIDStr, Color.color(1, 1, 1)),
                squareText
        );
        HBox.setHgrow(squareText, Priority.ALWAYS);

        FlowPane pane2 = new FlowPane();

        fillSquareBackgroundColor(pane2, squareSpeciality);

        pane2.setAlignment(Pos.CENTER);

        VBox.setVgrow(pane2, Priority.ALWAYS);

        getChildren().addAll(
                pane1,
                pane2
        );
    }

    void fillSquareBackgroundColor(FlowPane pane, ISquareModel.Speciality speciality) {
        pane.getStyleClass().add("icon");
        if (speciality == ISquareModel.Speciality.Enseignement_Anglais) {
            pane.setId("angIcon");
        } else if (speciality == ISquareModel.Speciality.Enseignement_Maths) {
            pane.setId("mathsIcon");
        } else if (speciality == ISquareModel.Speciality.Enseignement_Info) {
            pane.setId("infoIcon");
        } else if (speciality == ISquareModel.Speciality.Enseignement_Economie) {
            pane.setId("ecoIcon");
        } else if (speciality == ISquareModel.Speciality.Examen) {
            pane.setId("examIcon");
        } else if (speciality == ISquareModel.Speciality.Redoublement) {
            pane.setId("redoubleIcon");
        } else if (speciality == ISquareModel.Speciality.Antiseche) {
            pane.setId("antisecheIcon");
        } else if (speciality == ISquareModel.Speciality.Jeudi) {
            pane.setId("jeudiIcon");
        } else if (speciality == ISquareModel.Speciality.Soiree) {
            pane.setId("soireeIcon");
        } else if (speciality == ISquareModel.Speciality.Diplome) {
            pane.setId("diplomeIcon");
        } else {
            pane.setStyle("-fx-background-color: white;");
        }
    }
}
