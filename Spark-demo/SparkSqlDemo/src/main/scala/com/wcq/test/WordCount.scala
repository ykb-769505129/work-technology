package com.wcq.test

import org.apache.spark.sql
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import org.slf4j.LoggerFactory

case class People(name:String,age:Long)


object WordCount {

  def main(args: Array[String]): Unit = {


    //创建SparkConf()并设置App名称
    val spark = SparkSession
      .builder()
      .master("local[*]")
      .appName("Spark SQL basic example")
      //.config("spark.some.config.option", "some-value")
      .getOrCreate()

    //导入隐式转换
    import spark.implicits._

    //读取本地文件，创建DataFrame
    val df: DataFrame = spark.read.json("D:\\project\\Spark-demo\\SparkSqlDemo\\src\\data\\people.json")

    df.select("name").show

    println("------------------")


    df.createTempView("people")

    spark.sql("select * from people").show

    df.rdd

    df.as[People]


    spark.stop()




  }
}
