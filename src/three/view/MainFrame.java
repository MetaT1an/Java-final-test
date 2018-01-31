package three.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import three.control.FunControl;
import three.control.InfoControl;

public class MainFrame extends Application{

    public static BorderPane borderPane = new BorderPane();

    public void start(Stage stage){

        borderPane.setCenter(WelcomePage.getInstance().getCanvas());
        borderPane.setLeft(Console.getConsoleL().getvBox());
        borderPane.setRight(Console.getConsoleR().getvBox());


        BorderPane.setMargin(borderPane.getLeft(), new Insets(0, 0, 0, 20));
        BorderPane.setMargin(borderPane.getRight(), new Insets(0, 20, 0, 0));


        InfoControl.addAllPageEvents();
        InfoControl.addmenuEvents();
        FunControl.addFunEvents();

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

}
