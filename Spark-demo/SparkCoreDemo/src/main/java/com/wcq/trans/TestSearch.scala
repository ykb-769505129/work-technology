package com.wcq.trans

import org.apache.spark.{SparkConf, SparkContext}

object TestSearch {
  def main(args: Array[String]): Unit = {
    //1.创建SparkConf
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Practice")

    //2.创建SparkContext
    val sc = new SparkContext(sparkConf)

    //创建一个RD
    val word = sc.makeRDD(Array("a", "b", "c", "d"))

    //创建Search对象
    val search = new Search("a")

    //对RDD进行过滤
    val filted = search.getMatch1(word)

    //打印
    filted.foreach(println)

    //关闭连接
    sc.stop()

  }
}
