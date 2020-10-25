package com.wcq.test

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object RDDToDF {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .master("local[*]")
      .appName("RDDToDF")
      .getOrCreate()

    import spark.implicits._

    val rdd: RDD[Int] = spark.sparkContext.parallelize(Array(1, 2, 3, 4))

    val rowRDD: RDD[Row] = rdd.map(x=>{
      Row(x)
    })

    //创建结构信息
    val structType = StructType(StructField("id", IntegerType) :: Nil)

    val df:DataFrame = spark.createDataFrame(rowRDD, structType)

    df.show

    spark.stop()
  }
}
