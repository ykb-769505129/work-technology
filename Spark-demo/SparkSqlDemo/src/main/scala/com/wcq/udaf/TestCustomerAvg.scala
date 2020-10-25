package com.wcq.udaf

import org.apache.spark.sql.{DataFrame, SparkSession}

object TestCustomerAvg {

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

    df.createTempView("people")

    spark.udf.register("MyAvg",CustomerAvg)

    spark.sql("select MyAvg(age) from people").show

    spark.stop()
  }
}
