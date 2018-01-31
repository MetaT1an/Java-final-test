package three.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class TransacPage {

    private GridPane transacPane;
    private Label[] items;
    private TextField[] values;
    private Button confirm;
    private String type;

    public TransacPage(String type){
        transacPane = new GridPane();
        items = new Label[4];
        values = new TextField[4];
        confirm = new Button();
        this.type = type;

        setModule();
        loadModule();
    }

    public TextField getTextField(int i){
        return values[i];
    }

    public Button getConfirm() {
        return confirm;
    }

    public GridPane getTransacPane() {
        return transacPane;
    }

    public String getType(){
        return type;
    }

    private void setModule(){
        for(int i = 0; i < 4; i++){
            items[i] = new Label();
            items[i].setFont(Font.font(18));

            values[i] = new TextField();
            values[i].setFont(Font.font(18));
            values[i].setPrefSize(150,30);
        }
        items[0].setText("账户名：");
        items[1].setText("密  码：");
        items[2].setText("金  额：");
        items[3].setText("责任者：");

        confirm.setFont(Font.font(16));
        confirm.setText("Confirm");
        confirm.setPrefSize(88,32);
    }

    private void loadModule(){
        for(int i = 0; i < 4; ++i){
            transacPane.add(items[i], 0, i);
            transacPane.add(values[i], 1, i);
        }
        transacPane.add(confirm, 0, 4);

        transacPane.setAlignment(Pos.CENTER);
        transacPane.setVgap(15);
        transacPane.setPrefSize(400,400);
    }



}
