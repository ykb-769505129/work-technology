package com.wcq.practice

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Practice {
  def main(args: Array[String]): Unit = {

    //1.创建SparkConf
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Practice")

    //2.创建SparkContext
    val sc = new SparkContext(sparkConf)

    //3.读取文件(agent.log):时间戳（TS），省份（Pro），城市（City），用户（User），广告（ad）
    val line = sc.textFile("D:\\桌面\\agent.log")

    //4.提取省份和广告字段：（（）Pro，ad），1）
    val proADToOne = line.map(x => {
      val fields = x.split(" ")
      ((fields(1), fields(4)), 1)
    })

    //5.求出每个省份每个广告被点击的总次数（（pro，ad），count）
    val proADToCount = proADToOne.reduceByKey(_+_)

    //6.扩大粒度（pro，（ad,count））
    val proToADcount:RDD[(String,(String,Int))] = proADToCount.map(x => (x._1._1, (x._1._2, x._2)))

    //7.按照省份分组
    val proToADCountList: RDD[(String, Iterable[(String,Int)])] = proToADcount.groupByKey()

    //8.排序
    val result: RDD[(String, List[(String,Int)])] = proToADCountList.mapValues { x =>
      x.toList.sortWith((a, b) => a._2 > b._2).take(3)
    }
    //9.打印
    result.collect().foreach(println)

    //10.关闭连接
    sc.stop()
  }
}
