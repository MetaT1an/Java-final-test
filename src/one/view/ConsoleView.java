package one.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ConsoleView {
    private TextField textField;
    private Button set;
    private RadioButton[] modeSelection;
    private ToggleGroup tgroup;
    private Button[] function;
    private VBox console;
    private Font font;

    private static ConsoleView consoleView = null;

    public static ConsoleView getInstance(){
        if(consoleView == null)
            consoleView = new ConsoleView();
        return consoleView;
    }

    private ConsoleView(){
        font = Font.font(20);
        tgroup = new ToggleGroup();
        textField = new TextField();
        textField.setPrefSize(120, 40);
        textField.setFont(font);

        set = new Button("Set N");
        set.setPrefSize(100,28);
        set.setFont(font);

        modeSelection = new RadioButton[2];
        for(int i = 0; i < 2; ++i){
            modeSelection[i] = new RadioButton();
            modeSelection[i].setFont(font);
            modeSelection[i].setToggleGroup(tgroup);
        }

        function = new Button[5];
        for(int i = 0; i < 5; i++){
            function[i] = new Button();
            function[i].setFont(font);
            function[i].setPrefSize(100,28);
        }

        function[3].setDisable(true);
        function[2].setDisable(true);

        console = new VBox(20);

        setModule();
        loadModule();
    }

    public Button getSet(){
        return set;
    }

    public TextField getTextField() {
        return textField;
    }

    public RadioButton getMode(int i){
        return modeSelection[i];
    }

    public Button getFunction(int i) {
        return function[i];
    }

    public VBox getConsole() {
        return console;
    }

    private void setModule(){
        textField.setPromptText("8 ~ 13");

        modeSelection[0].setText("PlayMode");
        modeSelection[0].setSelected(true);

        modeSelection[1].setText("SoluMode");
        modeSelection[1].setSelected(false);

        function[0].setText("Check");
        function[1].setText("Reset");
        function[2].setText("Last");
        function[3].setText("Next");
        function[4].setText("Quit");
    }

    private void loadModule(){
        console.getChildren().addAll(modeSelection);
        console.getChildren().addAll(textField, set);
        console.getChildren().addAll(function);

        VBox.setMargin(textField, new Insets(20,0,0,0));
        VBox.setMargin(function[0],new Insets(20,0,0,0));
        console.setAlignment(Pos.CENTER);
    }
}
