package three.control;

import javafx.scene.control.Alert;
import three.model.Client;
import three.model.Transaction;
import three.view.*;

import java.util.ArrayList;

public class InfoControl {
    private static InqPage inqPage = InqPage.getInqPage();
    private static LoginPage loginPage = LoginPage.getLoginPage();

    private static Console consoleL = Console.getConsoleL();

    public static void addAllPageEvents(){
        loginPagevents();
        inqPageEvents();
    }

    private static void loginPagevents(){
        loginPage.getButton(0).setOnAction(event -> {
            loginPage.clear();
        });

        loginPage.getButton(1).setOnAction(event -> {

            String name = loginPage.getTextField(0).getText();
            String passWord = loginPage.getTextField(1).getText();
            String tel = loginPage.getTextField(2).getText();
            String address = loginPage.getTextField(3).getText();

            Client client = new Client(name, passWord, address, tel);
            FileOperation.addClient(client);
            showSignUpInfo();

        });
    }

    private static void inqPageEvents(){
        inqPage.getSubmit().setOnAction(event -> {
            String name = inqPage.getContent(0).getText();
            String passWord = inqPage.getContent(1).getText();

            ArrayList<Client> cList = FileOperation.getAllClients();
            ArrayList<Transaction> tList = FileOperation.getAllTscRecords();

            for(Client c : cList){
                if(c.getName().equals(name) && c.getPassWord().equals(passWord)){

                    InfoPage infoPage = new InfoPage();

                    for(Transaction t : tList){
                        if(t.getAccount().equals(name)){
                            infoPage.getRecords().appendText(t.toString());
                            infoPage.getRecords().appendText("\n");
                        }
                    }
                    infoPage.setValues(c.getId(), c.getName(), c.getMoney(), c.getTel(), c.getAddress());

                    changeToInfoPage(infoPage);
                    return;
                }
            }
            showValidInfo();
        });
    }

    private static void changeToWelcomePage(){
        MainFrame.borderPane.setCenter(WelcomePage.getInstance().getCanvas());
    }

    public static void changeToInqPage(){
        inqPage.clear();
        MainFrame.borderPane.setCenter(inqPage.getInqPane());
    }

    private static void changeToInfoPage(InfoPage infoPage){
        MainFrame.borderPane.setCenter(infoPage.getInfoPane());

    }

    public static void changeToLoginPage(){
        loginPage.clear();
        MainFrame.borderPane.setCenter(loginPage.getLoginPane());
    }

    private static void showValidInfo(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setTitle("Information");
        a.setHeaderText("Checking account...");
        a.setContentText("账号或密码错误！请重新输入");
        a.showAndWait();
    }

    private static void showSignUpInfo(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setTitle("Information");
        a.setHeaderText("系统提醒");
        a.setContentText("账号开通成功，初始金额为￥1.00元");
        a.showAndWait();
    }

    public static void addmenuEvents(){
        consoleL.getButtons(0).setOnAction(event -> {
            changeToLoginPage();
        });

        consoleL.getButtons(1).setOnAction(event -> {
            changeToInqPage();
        });

        consoleL.getButtons(2).setOnAction(event -> {
            changeToWelcomePage();
        });
    }

}
