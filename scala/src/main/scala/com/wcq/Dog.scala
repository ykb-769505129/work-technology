package com.wcq



object TestDog {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    dog.name = "旺财"
    dog.age = 2
    dog.weight = 6
    println(dog.say())

  }

  class Dog {

    var name = ""
    var age = 0
    var weight:Double = 0.0
    def say(): String ={
      "name="+this.name+",age="+this.age+",weight="+this.weight
    }

  }



}