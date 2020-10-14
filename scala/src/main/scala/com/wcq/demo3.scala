package com.wcq

import scala.collection.mutable.ArrayBuffer

object demo3 {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"

    def putArry( arr : ArrayBuffer[Char], c : Char ): ArrayBuffer[Char] = {
      arr.append(c)
      arr
    }

    val arr = ArrayBuffer[Char]()
    sentence.foldLeft(arr)(putArry)
    println(arr)

  }
}
