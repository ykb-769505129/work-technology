package com.wcq

import scala.collection.mutable.ArrayBuffer

object demo1 {
  def main(args: Array[String]): Unit = {
//  val names = List("Alice","Bob","Nick")
//
//    def upper(s:String):String = {
//      s.toUpperCase
//    }
//
//    println(names.flatMap(upper))
//    //List(A, L, I, C, E, B, O, B, N, I, C, K)
//
//    val names =List("Alice","Bob","Nick")
//    def startA(s:String):Boolean={
//      s.startsWith("A")
//    }
//
//    val names2 = names.filter(startA)
////    println("names2="+names2) //names2=List(Alice)

    //      val list = List(1,20,30,4,5)
//      def sum(n1:Int,n2:Int):Int={
//        n1 + n2
//      }
//
//      val res = list.reduceLeft(sum)
//      println("res="+res) //res=60

    val list = List(1,2,3,4,5)
    def minus(num1:Int,num2:Int):Int={
      num1 - num2
    }
    //(((1-2)-3)-4)-5 = -13
    println(list.reduceLeft(minus)) //-13
    //1-(2-(3-(4-5))) = 3
    println(list.reduceRight(minus)) //3
    //reduce 等价于 reduceLeft
    println(list.reduce(minus))// -13

  }
}
