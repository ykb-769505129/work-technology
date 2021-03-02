package com.example.design.简单工厂模式;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) throws Exception {
        client();
    }

    public static void client() throws Exception {
        Operation oper;
        oper = OperationFactory.createOperate("*");
        oper.set_numberA(1);
        oper.set_numberB(2);
        double result = oper.GetResult();
        System.out.println(result);
    }

}
