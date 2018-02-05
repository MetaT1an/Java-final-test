package three.control;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import three.model.Client;
import three.model.Transaction;
import three.view.Console;
import three.view.MainFrame;
import three.view.TransacPage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class FunControl {
    private static Console consoleR = Console.getConsoleR();

    public static void addFunEvents(){

        consoleR.getButtons(0).setOnAction(event -> {
            TransacPage transacPage = new TransacPage("存款");
            changeToTransacPage(transacPage);
            transacPageEvent(transacPage);
        });

        consoleR.getButtons(1).setOnAction(event -> {
            TransacPage transacPage = new TransacPage("取款");
            changeToTransacPage(transacPage);
            transacPageEvent(transacPage);
        });

        consoleR.getButtons(2).setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Confirmation");
            alert.setHeaderText("");
            alert.setContentText("Do you want to quit the system?");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK){
                System.exit(0);
            }
        });
    }

    private static void changeToTransacPage(TransacPage transacPage){
        MainFrame.borderPane.setCenter(transacPage.getTransacPane());
    }

    private static void transacPageEvent(TransacPage transacPage){
        transacPage.getConfirm().setOnAction(event -> {
            //1.find the object client
            ArrayList<Client> clients = FileOperation.getAllClients();
            Client client = getClient(clients, transacPage.getTextField(0).getText());

            double money = Double.parseDouble(transacPage.getTextField(2).getText());
            if(transacPage.getType().equals("取款") && money > client.getMoney()){
                notEnoughMoneyInfo();
                return;
            }

            Date currentDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String date = simpleDateFormat.format(currentDate);

            String name = transacPage.getTextField(0).getText();
            String charger = transacPage.getTextField(3).getText();

            if(transacPage.getType().equals("取款")){
                client.withDraw(-1 * money);
            } else {
                client.deposit(money);
            }
            Transaction transaction = new Transaction(name, date, transacPage.getType(), money,charger);

            FileOperation.writeBack(clients);
            FileOperation.addTscRecord(transaction);
            showTransacInfo(transacPage.getType(),money);
        });
    }

    private static void showTransacInfo(String type, double money){
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setTitle("Information");
        a.setHeaderText("系统提醒");
        a.setContentText(type + "操作成功！" + "金额为：￥" + money);
        a.showAndWait();
    }

    private static void notEnoughMoneyInfo(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setTitle("Information");
        a.setHeaderText("系统提醒");
        a.setContentText("非法金额！");
        a.showAndWait();
    }

    private static Client getClient(ArrayList<Client> clientArrayList, String name){
        for(Client c : clientArrayList){
            if(c.getName().equals(name))
                return c;
        }
        return null;
    }
}
