package three.model;

import java.io.Serializable;

public class Client implements Serializable{
    private static int num = 0;

    private int id;
    private String name;
    private String passWord;
    private String address;
    private String tel;
    private double money;

    public Client(String name, String passWord,  String address, String tel){
        this.name = name;
        this.passWord = passWord;
        this.address = address;
        this.tel = tel;
        this.money = 1;
        this.id = num++;
    }

    @Override
    public String toString(){
       return String.format("编号：%d\n姓名：%s\n密码：%s\n地址：%s\n电话：%s\n总金额：￥%.2f\n",
               id, name, passWord, address, tel, money);
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public double getMoney() {
        return money;
    }

    public void deposit(double money){
        this.money += money;
    }

    public boolean withDraw(double money){
        boolean withDrawRes;

        if(this.money < money)
            withDrawRes = false;
        else{
            this.money -= money;
            withDrawRes = true;
        }
        return withDrawRes;
    }
}