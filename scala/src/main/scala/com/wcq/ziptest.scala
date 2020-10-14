package com.wcq

object ziptest {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,2,3)
    val list2 = List(4,5,6)
    val list3 = list1.zip(list2)
    println("list3="+list3) //list3=List((1,4), (2,5), (3,6))

    val iterator = List(1,2,3,4,5).iterator
    println("--------遍历方式1-----------")
    while(iterator.hasNext){
      println(iterator.next())
    }

    println("---------遍历方式2-------------")
    for(enum <- iterator){
      println(enum)
    }
  }
}
