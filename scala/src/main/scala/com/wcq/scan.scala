package com.wcq

object scan {
  def main(args: Array[String]): Unit = {

    def minus(num1:Int,num2:Int):Int={
      num1 - num2
    }

    val i8 = (1 to 5).scanLeft(5)(minus)
    println(i8) //Vector(5, 4, 2, -1, -5, -10)

    def add(num1:Int,num2:Int):Int={
      num1 + num2
    }
    val i9 = (1 to 5).scanLeft(5)(add)
    println(i9) //Vector(5, 6, 8, 11, 15, 20)

  }
}
