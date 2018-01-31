package three.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class InfoPage {

    private GridPane infoPane;
    private TextArea records;
    private Label[] items;//账户编号，账户名，总金额，电话，住址，
    private Label[] values;

    public InfoPage(){
        infoPane = new GridPane();
        records = new TextArea();
        items = new Label[5];
        values = new Label[5];

        setItems();
        loadModules();
    }

    public TextArea getRecords() {
        return records;
    }

    public GridPane getInfoPane(){
        return infoPane;
    }

    private void setItems(){
        for(int i = 0; i<5; ++i){
            items[i] = new Label();
            values[i] = new Label();

            items[i].setFont(Font.font(18));
            values[i].setFont(Font.font(18));
        }
        items[0].setText("编  号：");
        items[1].setText("账户名：");
        items[2].setText("总金额：");
        items[3].setText("电  话：");
        items[4].setText("住  址");

        records.setFont(Font.font(20));
        records.setPrefSize(350,170);
    }

    public void setValues(int id, String name, double money, String tel, String address){
        values[0].setText(String.valueOf(id));
        values[1].setText(name);
        values[2].setText(String.valueOf(money));
        values[3].setText(tel);
        values[4].setText(address);
    }

    private void loadModules(){
        for(int i = 0; i<5; ++i){
            infoPane.add(items[i],0,i);
            infoPane.add(values[i],1,i);
        }
        infoPane.add(records,0,5,2,2);

        infoPane.setAlignment(Pos.CENTER);
        infoPane.setPrefSize(400, 400);
        infoPane.setHgap(20);
        infoPane.setVgap(8);
    }
}
