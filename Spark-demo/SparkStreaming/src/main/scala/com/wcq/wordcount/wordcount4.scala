package com.wcq.wordcount

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object wordcount4 {

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

    //6.聚会4个批次的数据（12s） 每隔三秒计算触发一次运算
    val wordAndCount = wordAndOne.reduceByKeyAndWindow((x: Int, y: Int) => x + y, Seconds(12), Seconds(3))

    //7.打印
    wordAndCount.print

    //8.启动
    ssc.start()

    ssc.awaitTermination()


  }
}
