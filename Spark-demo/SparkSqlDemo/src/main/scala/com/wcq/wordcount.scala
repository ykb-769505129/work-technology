package com.wcq

import org.apache.spark.{SparkConf, SparkContext}

object wordcount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("wordcount").setMaster("local[*]")

    val sc = new SparkContext(sparkConf)

    sc.textFile("E:\\input\\a.txt").flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).collect().foreach(println)

    sc.stop()
  }
}
