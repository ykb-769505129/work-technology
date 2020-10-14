package com.wcq

object WordCount {
  def main(args: Array[String]): Unit = {
    val lines = List("atguigu han hello ",
      "atguigu han aaa aaa aaa ccc ddd uuu")

    //val res1 = lines.flatMap((s:String) => s.split(" "))
    //简化
    val res1 = lines.flatMap(_.split(" "))
    println("res1="+res1)

    //val res2 = res1.map((s:String)=> (s,1))
    //简化
    val res2 = res1.map((_,1))
    println("res2="+res2)

   // val res3 = res2.groupBy((x:(String,Int)) => x._1)
    //简化
    val res3 = res2.groupBy(_._1)
    println("res3="+res3)

    //val res4 = res3.map((x:(String,List[(String,Int)])) => (x._1,x._2.size))
    //简化
    val res4 = res3.map(x => (x._1,x._2.size))
    println("res4="+res4)

    //val res5 = res4.toList.sortBy((x:(String,Int))=>x._2)
    val res5 = res4.toList.sortBy(_._2)
    println("res5="+res5)
    println("------------------------------------------------------------------")
    println(lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(x => (x._1, x._2.size)).toList.sortBy(_._2))
  }
}
