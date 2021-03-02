package com.example.design.策略模式;

public class CashReturn extends CashSuper {

    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;

    public CashReturn (String moneyCondition, String moneyReturn){
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition && moneyCondition > 0)
            result = money - money/moneyCondition * moneyReturn;
        return result;
    }
}
