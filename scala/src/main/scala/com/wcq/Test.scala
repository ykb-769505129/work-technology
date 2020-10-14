package com.wcq

object Test {
  def main(args: Array[String]): Unit = {
    var a = 10
    var b = 20
    a = a + b
    b = a - b
    a = a - b
    println(a ,b)
  }
}
