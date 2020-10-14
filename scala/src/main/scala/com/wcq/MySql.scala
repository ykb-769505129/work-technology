package com.wcq

class MySql {
def insert():Unit={
  println("insert")
}
}

class DB{
  def delete():Unit={
    println("delete")
  }
}
object implicittest{

  def main (args: Array[String] ): Unit = {

  }
  implicit def addDelete(mysql:MySql):DB={
    new DB
  }
  val mysql = new MySql
  mysql.insert()
  mysql.delete()
}
