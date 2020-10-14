package com.wcq

object Test1 {
  def main(args: Array[String]): Unit = {
    val num = if(5>4)5 else 4
    val num1 = if(num > 7)num else 7
    println(num1)
  }
}
