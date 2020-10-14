package com.wcq

object viewtest {
  def main(args: Array[String]): Unit = {
    def multiple(num: Int): Int = {
      num}
    def eq(i: Int): Boolean = {
      i.toString.equals(i.toString.reverse)
    }
    //说明: 没有使用view
    val viewSquares1 = (1 to 100)
      .filter(eq)
    println(viewSquares1)
    //for (x <- viewSquares1) {}
    //使用view
    val viewSquares2 = (1 to 100)
      .view
      .filter(eq)
    println(viewSquares2)
    for(item <- viewSquares2){
      println("item="+item)
    }

  }
}
