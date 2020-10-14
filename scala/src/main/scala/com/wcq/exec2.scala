package com.wcq

object exec2 {
  def main(args: Array[String]): Unit = {

    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDD"
    def charCount(map:Map[Char,Int],c:Char):Map[Char,Int]={
      map + (c -> (map.getOrElse(c, 0) + 1))
    }

    val map2 = sentence.foldLeft(Map[Char,Int]())(charCount)

    println(map2)
  }
}
