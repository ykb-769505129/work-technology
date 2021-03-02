package com.example.design.装饰模式;

public class Clothing {
}


class TShirts extends Finery {

    public void show(){
        System.out.print("大T桖 ");
        super.show();
    }

}

class BigTrouser extends Finery{

    public void show(){
        System.out.print("垮裤 ");
        super.show();
    }

}

class WearSneakers extends Finery{

    public void show(){
        System.out.print("破网鞋 ");
        super.show();
    }

}

class WearSuit extends Finery{

    public void show(){
        System.out.print("西装 ");
        super.show();
    }

}

class WearTie extends Finery{

    public void show(){
        System.out.print("领带 ");
        super.show();
    }

}

class WearLeatherShoes extends Finery{

    public void show(){
        System.out.print("皮鞋 ");
        super.show();
    }

}