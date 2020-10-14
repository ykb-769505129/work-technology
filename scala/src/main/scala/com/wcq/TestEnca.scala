package com.wcq

object TestEnca {
  def main(args: Array[String]): Unit = {

    var p = new Person1
    println(p.setAge(15))
  }
}

class Person1{
  private var name:String = _
  private var age:Int = _
  private var job:String = _

  def setAge(age:Int):Unit ={
    if(age >= 0 && age <=120){
      this.age = age
    }else{
      println("输入的数据不合理")
      this.age = age
    }
  }
}

