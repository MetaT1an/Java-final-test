package two.control;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import two.model.Comparators;
import two.model.StuInfo;
import two.view.Console;
import two.view.InfoCenter;
import two.view.MainFrame;

import java.util.ArrayList;
import java.util.Optional;

public class ConsoleControl {
    private static InfoCenter infoCenter = InfoCenter.getInfoCenter();
    private static Console console = Console.getConsole();

    public static void addFunctionEvents(){
        addRecord();
        inquireRc();
        quit();
        selecEvents();
    }


    public static void changeSceneToCanvas(){
        MainFrame.getBorderPane().setCenter(infoCenter.getCanvas());
        BorderPane.setMargin(infoCenter.getCanvas(), new Insets(20,20,20,20));
    }

    private static void changeSceneToGrid(){
        MainFrame.getBorderPane().setCenter(infoCenter.getGridPane());
        BorderPane.setMargin(infoCenter.getGridPane(), new Insets(20,20,20,20));
    }

    private static void changeSceneToText(){
        MainFrame.getBorderPane().setCenter(infoCenter.getTextArea());
        BorderPane.setMargin(infoCenter.getTextArea(), new Insets(20,20,20,20));
    }

    private static void addRecord(){
        console.getFunc(0).setOnAction(event -> {
            setSelecsDisable(true);
            changeSceneToGrid();
        });
    }

    private static void inquireRc(){
        console.getFunc(1).setOnAction(event -> {
            setSelecsDisable(false);
            changeSceneToText();
        });
    }

    private static void quit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation");
        alert.setHeaderText("");
        alert.setContentText("Do you want to quit the system?");

        console.getFunc(2).setOnAction(event -> {
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                System.exit(0);
            }
        });
    }

    private static void setSelecsDisable(boolean choice){
        for(int i = 0; i<3; ++i){
            console.getSelecs(i).setDisable(choice);
        }
    }

    private static void selecEvents(){
        console.getSelecs(0).setOnAction(event -> {
            ArrayList<StuInfo> list = FileOperation.getRecords();
            list.sort(new Comparators.nameComparator());

            showInfo(list);
        });

        console.getSelecs(1).setOnAction(event -> {
            ArrayList<StuInfo> list = FileOperation.getRecords();
            list.sort(new Comparators.idComparator());

            showInfo(list);
        });

        console.getSelecs(2).setOnAction(event -> {
            ArrayList<StuInfo> list = FileOperation.getRecords();
            list.sort(new Comparators.scoreComparator());
            showInfo(list);

        });
    }

    private static void showInfo(ArrayList<StuInfo> list){
        infoCenter.getTextArea().clear();
        for(StuInfo stuInfo : list){
            infoCenter.getTextArea().appendText(stuInfo.toString());
        }
    }
}
