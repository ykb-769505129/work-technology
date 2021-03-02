package com.example.design.装饰模式;

public class Finery extends Person {

    protected Person component;

    public void decorate(Person component){
        this.component = component;
    }

    public void show(){
        if (component != null){
            component.show();
        }
    }

}
