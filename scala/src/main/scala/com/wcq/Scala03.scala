package com.wcq

object Scala03 {
  def main(args: Array[String]): Unit = {

//    implicit val name :String = "Scala"
//
//    def hello(implicit context: String ="okokok"):Unit={
//      println("hello" +context)//helloScala
//    }
//    hello
//    implicit val name :Int = 10
//    def hello(implicit context:String="okokok"):Unit={
//      println("hello" + context)//hellookokok
//    }
//    hello
//  }

  implicit val name :Int = 10
  def hello(implicit context:String):Unit={
    println("hello" + context)//
  }
//  hello //报错


  }
}
