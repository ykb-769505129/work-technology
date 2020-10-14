package com.wcq

object fold {
  def main(args: Array[String]): Unit = {
    val list =List(1,2,3,4)

    def minus (num1:Int ,num2 : Int):Int={
      num1 - num2
    }

    //说明：
    //1 折叠的理解和化简的运行机制几乎一样
    // 步骤1 list.foldleft(5)(minus) 理解成list(5,1,2,3,4)list.recueLeft
    //(5-1)   ((5-1)-2) (((5-1)-2)-3) ((((5-1)-2)-3)-4)
    // 函数的柯里化
    println(list.foldLeft(5)(minus))
    //(1-(2-(3-(4-5))))
    println(list.foldRight(5)(minus))
    //var i6 = (1 /: list4) (minus) //
    // =等价=> list4.foldLeft(1)(minus)

  }
}
