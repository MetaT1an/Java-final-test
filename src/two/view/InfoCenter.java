package two.view;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class InfoCenter {
    //scene 1
    private Canvas canvas;
    private GraphicsContext gc;

    //scene 2
    private GridPane gridPane;
    private Label[] labels;
    private TextField[] textFields;
    private Button[] buttons;

    //scene 3
    private TextArea textArea;

    private static InfoCenter infoCenter= null;

    public static InfoCenter getInfoCenter(){
        if(infoCenter == null)
            infoCenter = new InfoCenter();
        return infoCenter;
    }

    private InfoCenter() {
        canvas = new Canvas();
        gc = canvas.getGraphicsContext2D();

        gridPane = new GridPane();
        labels = new Label[3];
        textFields = new TextField[3];
        buttons = new Button[3];

        textArea = new TextArea();

        setModule();
        loadModule();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public Button getButton(int i){
        return buttons[i];
    }

    public TextField getTextField(int i){
        return textFields[i];
    }

    private void setModule(){
        for(int i = 0; i<3; ++i){
            labels[i] = new Label();
            labels[i].setPrefSize(80,36);
            labels[i].setFont(Font.font(18));
        }
        labels[0].setText("Name:");
        labels[1].setText("Id:");
        labels[2].setText("Score:");

        for(int i = 0; i<3; ++i){
            textFields[i] = new TextField();
            textFields[i].setPrefSize(150,36);
        }

        for(int i = 0; i<3; ++i){
            buttons[i] = new Button();
            buttons[i].setPrefSize(80,32);
            buttons[i].setFont(Font.font(14));
        }
        buttons[0].setText("Summit");
        buttons[1].setText("Next");
        buttons[2].setText("Quit");

        canvas.setWidth(500);
        canvas.setHeight(400);
        gridPane.setPrefSize(500,400);
        textArea.setPrefSize(500,400);

        textArea.setFont(Font.font(18));
    }

    private void loadModule(){
        gc.setFont(Font.font(50));
        gc.fillText("Java成绩管理系统",60,190);
        gc.setFont(Font.font(20));
        gc.fillText("V-1.0",410,220);

        gridPane.setVgap(36);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        for(int i = 0; i<3; i++){
            gridPane.add(labels[i],0,i);
            gridPane.add(textFields[i],1,i,2,1);
            gridPane.add(buttons[i],i,3);
        }
    }
}