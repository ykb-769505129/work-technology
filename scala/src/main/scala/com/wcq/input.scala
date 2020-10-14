package com.wcq

import scala.io.StdIn

object input {
  def main(args: Array[String]): Unit = {
    println("请输入名字：")
    val name = StdIn.readLine()
    println(name)
  }
}
