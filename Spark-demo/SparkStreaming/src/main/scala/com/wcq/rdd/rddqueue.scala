package com.wcq.rdd

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object rddqueue {

  def main(args: Array[String]): Unit = {

    //1.创建sparkconf
    val sparkConf = new SparkConf().setAppName("rddqueue").setMaster("local[*]")

    //2.创建streamingcontext
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    //3.创建RDD队列
    val rddQueue = new mutable.Queue[RDD[Int]]()

    //3.创建Dstream
    val rddStream = ssc.queueStream(rddQueue)

    //4.累加
    val result = rddStream.reduce(_ + _)

    //5.打印结果
    result.print()

    //6.开启流处理
    ssc.start()


    //循环创建
    for(i <- 1 to 5 ){
      rddQueue +=ssc.sparkContext.makeRDD(1 to 100,10)
      Thread.sleep(2000)
    }

    ssc.awaitTermination()
  }
}
