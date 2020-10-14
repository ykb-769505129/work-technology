package com.wcq

object PersonDemo {
  def main(args: Array[String]): Unit = {
    var p = new Person("sss",2)
    println(p.name)
  }
}

class Person {
  var name : String = _
  var age : Int = _
  def this(name:String,age:Int){
    this
    this.name=name
    this.age=age
  }

}
