package fr.ensicaen.ecole.genielogiciel;

import fr.ensicaen.ecole.genielogiciel.view.menuview.MenuMainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class GameMain extends Application {
    @Override
    public void start( final Stage primaryStage ) {
        MenuMainView view = new MenuMainView(primaryStage);
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main( String[] args ) {
        Application.launch(args);
    }
}
