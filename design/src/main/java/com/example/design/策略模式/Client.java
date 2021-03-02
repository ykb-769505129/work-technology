package com.example.design.策略模式;

/**
 * 客户端
 */
public class Client {

    static double total = 0.0d;
    static Object sender = null;
    static double money = 1d;


    public static void main(String[] args) {
        client01();
        client02();
        client03();
        client04();
    }

    public static void client01(){
        CashSuper csuper = CashFactory.createCashAccept("正常收费");
        double v = csuper.acceptCash(money);
        System.out.println("正常收费=>"+v);
    }

    public static void client02(){
        CashSuper csuper = CashFactory.createCashAccept("打8折");
        double v = csuper.acceptCash(money);
        System.out.println("打8折=>"+v);
    }

    public static void client03(){
        CashContext csuper = new CashContext("正常收费");
        double v = csuper.GetResult(1);
        System.out.println("正常收费=>"+v);
    }

    public static void client04(){
        CashContext csuper = new CashContext("打8折");
        double v = csuper.GetResult(1);
        System.out.println("打8折=>"+v);
    }

}
