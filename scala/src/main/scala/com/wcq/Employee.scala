package com.wcq

object TestEmployee{
  def main(args: Array[String]): Unit = {
    var w = new worker("张三",3000)
    println(showEmpAnnal(w))
    testWork(w)
  }
  def showEmpAnnal(e:Employee):Int={
  e.getAnnual()
  }
  def testWork(e:Employee):Unit={
    if(e.isInstanceOf[worker]){
      e.asInstanceOf[worker].work
    }else{
      e.asInstanceOf[manager].manage
    }
  }
}
 class Employee(inName:String,inSal:Int) {
  var name:String = inName
  var sal:Int = inSal

  def getAnnual():Int={
      this.sal * 12
  }
}

class manager (inName:String,inSal:Int,inBon:Int) extends Employee(inName:String,inSal:Int) {
  val bonus =inBon

  def manage: Unit ={
    println("管理员工")
  }

  override def getAnnual(): Int = {
    this.sal*12 + bonus
  }
}

class worker (inName:String,inSal:Int) extends Employee(inName:String,inSal:Int){

  def work:Unit={
    println("工作")
  }
  override def getAnnual(): Int = super.getAnnual()
}