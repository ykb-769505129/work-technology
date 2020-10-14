package com.wcq

object ExceptionDemo {
  def main(args: Array[String]): Unit = {

    try{
      val r = 10/0
    }catch {
      case ex:ArithmeticException=> println("捕获了分母为0的异常")
      case ex:Exception => println("捕获了异常")
    }finally {
      println("scala finally")
    }
  }
}
