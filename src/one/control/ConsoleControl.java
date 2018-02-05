package one.control;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import one.model.EightQueenModel;
import one.model.QueenList;
import one.view.ConsoleView;

import java.util.Optional;

public class ConsoleControl {
    private static QueenList qlist = QueenList.getInstance();
    private static EightQueenModel eightQueenModel = EightQueenModel.getInstance();
    private static ConsoleView consoleView = ConsoleView.getInstance();

    public static void addConsoleEvents(){
        modeSelectionEvent();
        setScaleEvent();
        checkEvent();
        resetEvent();
        stepEvent();
        quitEvent();
    }

    private static void modeSelectionEvent(){
        consoleView.getMode(0).setOnAction(event -> {
            ChessBoardControl.addChessBoardEvents();

            clearAll();

            consoleView.getFunction(0).setDisable(false);
            consoleView.getFunction(1).setDisable(false);
            consoleView.getFunction(2).setDisable(true);
            consoleView.getFunction(3).setDisable(true);
        });

        consoleView.getMode(1).setOnAction(event -> {
            generateSolution();
            ChessBoardControl.cancelAddQueenEvent();

            clearAll();

            consoleView.getFunction(2).setDisable(false);
            consoleView.getFunction(3).setDisable(false);
            consoleView.getFunction(0).setDisable(true);
            consoleView.getFunction(1).setDisable(true);
        });
    }

    private static void setScaleEvent(){
        consoleView.getSet().setOnAction(event -> {
            getScale();//change the scale of the game
            clearAll();
        });
    }

    private static void resetEvent(){
        consoleView.getFunction(1).setOnAction(event -> {
            clearAll();
        });
    }

    private static void checkEvent(){
        consoleView.getFunction(0).setOnAction(event -> {
            boolean valid = false;

            if(qlist.size() == 8) {
                for (int i = 0; i < qlist.size(); ++i) {
                    if (eightQueenModel.isValid(qlist.get(i).getX(), qlist.get(i).getY()))
                        valid = true;
                }
            }
            showInfo(valid);
        });
    }

    private static void quitEvent(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation");
        alert.setHeaderText("");
        alert.setContentText("Do you want to quit the game?");

        consoleView.getFunction(4).setOnAction(event -> {
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                System.exit(0);
            }
        });
    }

    private static void clearAll(){
        ChessBoardControl.clearBoard();//draw a new chess board
        qlist.clear();
        eightQueenModel.clear();
    }

    private static void showInfo(boolean valid){
        String result = "The result is " + (valid ? "Correct!" : "Incorrect!");

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information");
        a.setHeaderText("Checking result...");
        a.setContentText(result);
        a.showAndWait();
    }

    private static void generateSolution(){
        eightQueenModel.findSolution(0);
    }

    private static void stepEvent(){
        consoleView.getFunction(2).setOnAction(event -> {
            eightQueenModel.subPointer();
            ChessBoardControl.drawSolution();
        });

        consoleView.getFunction(3).setOnAction(event -> {
            eightQueenModel.addPointer();
            ChessBoardControl.drawSolution();
        });
    }

    private static void getScale(){
        int scale = 8;
        String s = consoleView.getTextField().getText();

        if(!"".equals(s) && Integer.parseInt(s) > 7 && Integer.parseInt(s) < 14)
            scale = Integer.parseInt(s);
        EightQueenModel.setN(scale);
    }
}
