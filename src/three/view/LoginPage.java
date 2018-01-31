package three.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class LoginPage {
    private GridPane loginPane;
    private Label[] items;
    private TextField[] values;
    private Button[] selection;

    private static LoginPage loginPage = new LoginPage();

    public static LoginPage getLoginPage(){
        return loginPage;
    }

    private LoginPage(){
        loginPane = new GridPane();
        items = new Label[4];
        values = new TextField[4];
        selection = new Button[2];

        setModule();
        loadModule();
    }

    public GridPane getLoginPane() {
        return loginPane;
    }

    public Button getButton(int i){
        return selection[i];
    }

    public TextField getTextField(int i){
        return values[i];
    }

    private void setModule(){
        for(int i = 0; i<4; i++){
            items[i] = new Label();
            items[i].setFont(Font.font(18));

            values[i] = new TextField();
            values[i].setFont(Font.font(16));
            values[i].setPrefSize(150,30);
        }
        items[0].setText("账户名：");
        items[1].setText("密  码：");
        items[2].setText("电  话：");
        items[3].setText("地  址：");

        for(int i = 0; i<2; ++i){
            selection[i] = new Button();
            selection[i].setPrefSize(75, 32);
            selection[i].setFont(Font.font(18));
        }

        selection[0].setText("重置");
        selection[1].setText("提交");
    }

    private void loadModule(){
        for(int i = 0; i<4; i++){
            loginPane.add(items[i], 0, i);
            loginPane.add(values[i], 1, i, 2, 1);
        }
        loginPane.add(selection[0], 0, 4);
        loginPane.add(selection[1], 2, 4);

        loginPane.setVgap(15);
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setPrefSize(400,400);
        GridPane.setMargin(selection[1], new Insets(0, 0, 0, 80));
    }

    public void clear(){
        for(int i = 0; i < 4; i++){
            loginPage.getTextField(i).clear();
        }
    }
}
