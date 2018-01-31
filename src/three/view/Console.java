package three.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Console {
    private VBox vBox;
    private Button[] funcs;

    private static Console consoleL = null;
    private static Console consoleR = null;

    public static Console getConsoleL(){
        if(consoleL == null){
            consoleL = new Console();
        }
        consoleL.getButtons(0).setText("开户");
        consoleL.getButtons(1).setText("查询");
        consoleL.getButtons(2).setText("返回");

        return consoleL;
    }

    public static Console getConsoleR(){
        if(consoleR == null){
            consoleR = new Console();
        }
        consoleR.getButtons(0).setText("存款");
        consoleR.getButtons(1).setText("取款");
        consoleR.getButtons(2).setText("退出");

        return consoleR;
    }

    private Console(){
        vBox = new VBox(30);
        funcs = new Button[3];
        setModule();
        loadModule();
    }

    public Button getButtons(int i){
        return funcs[i];
    }

    public VBox getvBox(){
        return vBox;
    }

    private void setModule(){
        for(int i = 0; i<3; i++){
            funcs[i] = new Button();
            funcs[i].setPrefSize(75,32);
            funcs[i].setFont(Font.font(18));
        }
    }

    private void loadModule(){
        vBox.getChildren().addAll(funcs);
        vBox.setAlignment(Pos.CENTER);
    }
}
