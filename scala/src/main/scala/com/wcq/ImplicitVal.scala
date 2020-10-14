package com.wcq

object ImplicitVal {
  def main(args: Array[String]): Unit = {
    implicit val str1:String = "jack"

    def hello(implicit name:String):Unit={
      println(name+ "hello")
    }

    def hello01():Unit={
      println("xxx")
    }
    hello
    hello01()
  }

}
