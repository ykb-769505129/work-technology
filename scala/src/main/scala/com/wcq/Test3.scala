package com.wcq

object Test3 {
  def main(args: Array[String]): Unit = {
    //println(f(2))
    println(peach(1))
  }
//  def f(n:Int):Int={
//      if(n==1){
//        3
//      }else{
//        2*f(n-1)+1
//      }
//  }
  //猴子吃桃子问题有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！以后每天猴子都吃其中的一半，
  // 然后再多吃一个。当到第十天时，想再吃时（还没吃），发现只有1个桃子了。
  // 问题：最初共多少个桃子？

  def peach(day:Int):Int={
    if(day == 10){
      1
    }else{
      (peach(day+1)+1)*2
    }
  }
}
