package com.example.design.简单工厂模式;

import lombok.Data;

/**
 * 运算类
 */
@Data
public abstract class Operation {

    private double _numberA = 0;
    private double _numberB = 0;

    public abstract double GetResult() throws Exception;

}
