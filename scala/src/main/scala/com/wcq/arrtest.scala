package com.wcq

import scala.collection.mutable.ArrayBuffer

object arrtest {
  def main(args: Array[String]): Unit = {
    val arr2 = ArrayBuffer[Int] ()

    arr2.append(7)
    arr2(0)=7

    println(arr2)
  }
}
