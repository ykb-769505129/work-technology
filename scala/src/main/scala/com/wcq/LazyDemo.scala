package com.wcq
//函数返回值被声明为lazy时，函数的执行将被推迟，
// 直到我们首次对此取值，该函数才会执行。
// 这种函数我们称之为惰性函数
object LazyDemo {
  def main(args: Array[String]): Unit = {
    lazy val res = sum(10,20)
    println("--------")
    println("res="+res)//在要使用res 前，才执行

    def sum(n1: Int, n2: Int):Int={
      println("sum()执行了")
      return n1+n2
    }
  }
}
