package three.model;

import java.io.Serializable;

public class Transaction implements Serializable{
    private static int num;

    private int id;
    private String account;
    private String date;
    private String type;
    private double money;
    private String charger;

    public Transaction(String account, String date, String type, double money, String charger) {
        this.account = account;
        this.date = date;
        this.type = type;
        this.money = money;
        this.charger = charger;
        this.id = num++;
    }

    public String getAccount(){
        return account;
    }

    public String toString(){
        return String.format("编号：%d\n账户：%s\n金额：%.2f\n类型：%s\n经办人：%s\n日期：%s\n"
        , id, account, money, type, charger, date);
    }
}
