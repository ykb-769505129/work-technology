package com.example.design.代理模式;

public class Proxy implements IGiveGift {

    Pursuit pursuit;

    public Proxy(SchoolGirl schoolGirl){
        this.pursuit = new Pursuit(schoolGirl);
    }

    @Override
    public void GiveDolls() {
        pursuit.GiveDolls();
    }

    @Override
    public void GiveFlowers() {
        pursuit.GiveFlowers();
    }

    @Override
    public void GiveChocolate() {
        pursuit.GiveChocolate();
    }
}
