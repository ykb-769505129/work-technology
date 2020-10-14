package com.wcq

object Test2 {
  def main(args: Array[String]): Unit = {
    println(fbnq(7))

  }

  //  def test (n: Int) {
  //    if (n > 2) {
  //      test (n - 1)
  //    }
  //    println("n=" + n) //n=2 n=3 n=4
  //  }
  //def test2 (n: Int) {
  //  if (n > 2) {
  //    test2 (n - 1)
  //  }else {
  //    println("n=" + n) //n=2
  //  }
  //}
  def fbnq(n: Int): Int = {
    if (n == 1 || n == 2) {
      1
    }else {
    fbnq(n-1) + fbnq(n-2)
  }



}
}
