package com.wcq.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object wordcount {

  def main(args: Array[String]): Unit = {

    //1、创建Sparkconf
    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("wordcount")

    //2、创建StreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    //3、创建Dstream
    val line = ssc.socketTextStream("hadoop102", 9999)

    //4.压平
    val word = line.flatMap(_.split(" "))

    //5.将单词转化为元组
    val wordAndOne = word.map((_, 1))

    //6.按照key聚合value
    val wordAndCount = wordAndOne.reduceByKey(_ + _)

    //7.打印
    wordAndCount.print()

    //8.开启流处理
    ssc.start()
    ssc.awaitTermination()


  }
}
