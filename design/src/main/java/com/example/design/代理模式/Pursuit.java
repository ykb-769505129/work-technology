package com.example.design.代理模式;

public class Pursuit implements IGiveGift {

    SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl){
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void GiveDolls() {
        System.out.println(schoolGirl.getName() + "送你洋娃娃");
    }

    @Override
    public void GiveFlowers() {
        System.out.println(schoolGirl.getName() + "送你鲜花");
    }

    @Override
    public void GiveChocolate() {
        System.out.println(schoolGirl.getName() + "送你巧克力");
    }
}
