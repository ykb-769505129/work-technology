package com.wcq.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object wordcount2 {
  def main(args: Array[String]): Unit = {

    //1、创建Sparkconf
    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("wordcount")

    //2、创建StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    //3、创建Dstream
    val line = ssc.socketTextStream("hadoop102", 9999)

    //4.转换为RDD操作
    val wordToCountDStream = line.transform(rdd => {
      val word = rdd.flatMap(_.split(" "))

      val wordToOne = word.map((_, 1))

      val wordToCount = wordToOne.reduceByKey(_ + _)

      wordToCount
    })

    //8.开启流处理
    ssc.start()
    ssc.awaitTermination()


  }
}
