package com.wcq.hbase

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.Result
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapred.TableInputFormat
import org.apache.spark.{SparkConf, SparkContext}

object TestHbase {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("TestHbase")

    val sc = new SparkContext(sparkConf)

    val conf = HBaseConfiguration.create()

    conf.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104")

    val hbaseRDD = sc.newAPIHadoopRDD(conf, Class[TableInputFormat],
      Class[ImmutableBytesWritable], Class[Result])

  }
}
