package com.wcq

object leftreduce {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)

    def min(n1:Int,n2:Int):Int={
      if(n1>n2)n2 else n1
    }

    println(list.reduceLeft(min))
  }
}
