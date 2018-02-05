package two.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Console {
    private VBox vBox;
    private Button[] funcs;
    private RadioButton[] selecs;
    private ToggleGroup toggleGroup;
    private Font font;

    private static Console console = null;

    public static Console getConsole(){
        if(console == null)
            console = new Console();
        return console;
    }

    private Console(){
        vBox = new VBox(20);
        funcs = new Button[3];
        selecs = new RadioButton[3];
        toggleGroup = new ToggleGroup();
        font = Font.font(16);

        setModule();
        loadModule();
    }

    public VBox getvBox() {
        return vBox;
    }

    public Button getFunc(int i){
        return funcs[i];
    }

    public RadioButton getSelecs(int i){
        return selecs[i];
    }

    private void setModule(){
        for(int i = 0; i<3; ++i){
            funcs[i] = new Button();
            funcs[i].setPrefSize(88,32);
            funcs[i].setFont(font);

            selecs[i] = new RadioButton();
            selecs[i].setToggleGroup(toggleGroup);
            selecs[i].setFont(font);
            selecs[i].setDisable(true);
        }

        funcs[0].setText("成绩录入");
        funcs[1].setText("成绩查询");
        funcs[2].setText("退出系统");

        selecs[0].setText("姓名排序");
        selecs[1].setText("学号排序");
        selecs[2].setText("成绩排序");
    }

    private void loadModule(){
        vBox.getChildren().add(funcs[0]);
        vBox.getChildren().add(funcs[1]);
        vBox.getChildren().addAll(selecs);
        vBox.getChildren().add(funcs[2]);

        vBox.setAlignment(Pos.CENTER);
    }


}
