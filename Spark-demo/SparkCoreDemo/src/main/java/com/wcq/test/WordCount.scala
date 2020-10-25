package com.wcq.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {

    //获取SparkConf
    val sparkConf: SparkConf= new SparkConf().setAppName("WordCount").setMaster("local[*]")

    //创建SparkContext
    val sc = new SparkContext(sparkConf)
     // sc.textFile().flatMap().map(_,1).reduceBykey(_+_).collect()
    //读取文件
    val line:RDD[String] = sc.textFile(args(0))

    //将一行数据压平
    val word:RDD[String] = line.flatMap(_.split(" "))

    //将单词映射为一个元组
    val wordAndOne: RDD[(String, Int)] = word.map((_, 1))

    //按照单词聚合次数
    val wordAndCount: RDD[(String, Int)] = wordAndOne.reduceByKey(_ + _)

    //保存到文件
    wordAndCount.saveAsTextFile(args(1))

    //关闭连接
    sc.stop()


  }


}
