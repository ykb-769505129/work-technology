package com.example.design.装饰模式;

public class Client {

    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
        Person person = new Person(" 小菜");
        System.out.println("第一种装扮：");
        BigTrouser kk = new BigTrouser();
        WearLeatherShoes wearLeatherShoes = new WearLeatherShoes();
        WearSuit wearSuit = new WearSuit();
        kk.decorate(person);
        wearLeatherShoes.decorate(kk);
        wearSuit.decorate(wearLeatherShoes);
        wearSuit.show();
    }

}
