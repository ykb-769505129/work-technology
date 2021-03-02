package com.example.design.装饰模式;

public class Person {

    public Person(){}

    private String name;

    public Person(String name){
        this.name = name;
    }

    public void show(){
        System.out.println("装扮的"+name);
    }
}
