package one.view;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import one.control.ChessBoardControl;
import one.control.ConsoleControl;

public class MainFrame extends Application {
    public void start(Stage stage){
        BorderPane borderPane = new BorderPane();

        //get components
        ChessBoard board = ChessBoard.getInstance();
        ConsoleView consoleView = ConsoleView.getInstance();

        //put components into right place
        borderPane.setCenter(board.getCanvas());
        borderPane.setRight(consoleView.getConsole());

        //set margin
        BorderPane.setMargin(consoleView.getConsole(), new Insets(0,20,0,20));

        //add all the events
        ChessBoardControl.addChessBoardEvents();
        ConsoleControl.addConsoleEvents();

        //run
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }
}
