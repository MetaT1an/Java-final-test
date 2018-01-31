package three.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class InqPage {
    private GridPane inqPane;
    private Label[] prompt;
    private TextField[] content;
    private Button submit;

    private static InqPage inqPage = new InqPage();

    public static InqPage getInqPage (){
        return inqPage;
    }

    private InqPage(){
        inqPane = new GridPane();
        prompt = new Label[2];
        content = new TextField[2];
        submit = new Button();

        setModule();
        loadModule();
    }

    public TextField getContent(int i) {
        return content[i];
    }

    public Button getSubmit() {
        return submit;
    }

    public GridPane getInqPane() {
        return inqPane;
    }

    private void setModule(){
        for(int i = 0; i<2; ++i){
            prompt[i] = new Label();
            content[i] = new TextField();

            prompt[i].setFont(Font.font(18));
            content[i].setFont(Font.font(18));

            content[i].setPrefSize(150,36);
        }

        prompt[0].setText("账户名称：");
        prompt[1].setText("账户密码：");

        submit.setText("Submit");
        submit.setPrefSize(75,38);
        submit.setFont(Font.font(15));
    }

    private void loadModule(){
        for(int i = 0; i<2; ++i){
            inqPane.add(prompt[i], 0, i);
            inqPane.add(content[i], 1, i);
        }
        inqPane.add(submit,1,2);

        inqPane.setAlignment(Pos.CENTER);
        inqPane.setPrefSize(400,400);
        inqPane.setVgap(30);
        inqPane.setHgap(20);
    }

    public void clear(){
        for(int i = 0; i<2; ++i){
            content[i].clear();
        }
    }

}
