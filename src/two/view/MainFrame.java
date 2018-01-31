package two.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import two.control.ConsoleControl;
import two.control.InfoControl;

public class MainFrame extends Application{

    private static BorderPane borderPane = new BorderPane();

    public static BorderPane getBorderPane(){
        return borderPane;
    }

    public void start(Stage stage){

        InfoCenter infoCenter = InfoCenter.getInfoCenter();
        Console console = Console.getConsole();

        borderPane.setCenter(infoCenter.getCanvas());
        borderPane.setRight(console.getvBox());

        BorderPane.setMargin(infoCenter.getCanvas(), new Insets(20,20,20,20));
        BorderPane.setMargin(console.getvBox(), new Insets(0,16,0,0));

        ConsoleControl.addFunctionEvents();
        InfoControl.addInfoEvents();

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }


}
