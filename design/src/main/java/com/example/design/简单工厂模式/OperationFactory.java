package com.example.design.简单工厂模式;

/**
 * 请求分配端
 */
public class OperationFactory {

    public static Operation createOperate(String operate){
        Operation oper = null;
        switch (operate){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }

}
