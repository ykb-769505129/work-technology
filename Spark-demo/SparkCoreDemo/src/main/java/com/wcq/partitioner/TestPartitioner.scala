package com.wcq.partitioner

import org.apache.spark.{SparkConf, SparkContext}

object TestPartitioner {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")

    val sc = new SparkContext(sparkConf)

    //创建rdd
    val value = sc.parallelize(Array((1, 2), (2, 3), (4, 5), (6, 7)))

    value.mapPartitionsWithIndex((i,items) => {
      items.map((i, _))
    }).foreach(println)

    val result = value.partitionBy(new CustomerPartitioner(5))


    result.mapPartitionsWithIndex((i,items) => {
      items.map((i,_))
    }).foreach(println)

    sc.stop()




  }
}
