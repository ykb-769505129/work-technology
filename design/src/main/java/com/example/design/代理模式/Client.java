package com.example.design.代理模式;

public class Client {

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        SchoolGirl jiaojiao = new SchoolGirl();
        jiaojiao.setName("李娇娇");
        Proxy daili = new Proxy(jiaojiao);

        daili.GiveDolls();
        daili.GiveFlowers();
        daili.GiveChocolate();

    }

}
