package com.wcq

object stream {
  def main(args: Array[String]): Unit = {

//    def numsForm(n:BigInt):Stream[BigInt] = n#:: numsForm(n+1)
//    val stream1 = numsForm(1)
//
//    println(stream1)
//    println("head="+stream1.head)
//    println(stream1.tail)
//    println(stream1)

    def numsForm(n: BigInt) : Stream[BigInt] = n #::numsForm(n + 1)
    def multi(x:BigInt) : BigInt = {
      x * x
    }
    println(numsForm(5).map(multi))
  }
}
