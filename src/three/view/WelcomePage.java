package three.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

public class WelcomePage {
    private Canvas canvas;
    private GraphicsContext gc;

    private static WelcomePage welcomePage = new WelcomePage();

    public static WelcomePage getInstance(){
        return welcomePage;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    private WelcomePage(){
        canvas = new Canvas(400,400);
        gc = canvas.getGraphicsContext2D();
        printWelcomInfo();
    }

    private void printWelcomInfo(){
        gc.setFont(Font.font(30));
        gc.fillText("欢迎使用储蓄管理系统",50,200);
    }
}
