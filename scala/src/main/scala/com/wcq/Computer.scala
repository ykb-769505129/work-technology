package com.wcq

object TestComputer{
  def main(args: Array[String]): Unit = {
    var pc = new PC
    var np = new NotePad

    pc.CPU = "I5 7500"
    pc.disk = "希捷"
    pc.mem ="威刚"
    pc.brand="三星"

    np.color="blue"
    np.CPU= "A13"
    np.disk= "威刚"
    np.mem = " xijie"
    pc.getDetails
    np.getDetails
  }
}
abstract class  Computer {
  var CPU: String = _
  var mem: String = _
  var disk: String = _

  def getDetails // 抽象方法, 没有方法体

}

class PC extends Computer{
  var brand:String = _

  override def getDetails: Unit = {
    println(CPU,mem,disk,brand)
  }
}

class NotePad extends Computer{
  var color:String= _

  override def getDetails: Unit = {
    println(CPU,color,mem,disk)
  }
}
