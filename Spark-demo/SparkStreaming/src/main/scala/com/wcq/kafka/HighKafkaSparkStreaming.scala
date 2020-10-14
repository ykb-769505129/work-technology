package com.wcq.kafka

import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{InputDStream, ReceiverInputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}


object HighKafkaSparkStreaming {

  def main(args: Array[String]): Unit = {

    //配置信息
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("HighKafkaSparkStreaming")

    //创建streamingcontext
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    //kafka参数
    val zookeeper = "hadoop102:2181,hadoop103:2181,hadoop104:2181"
    val topic = "source"
    val consumerGroup = "spark"


    //3.将kafka参数映射为map
    val kafkaParam: Map[String, String] = Map[String, String](
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
      ConsumerConfig.GROUP_ID_CONFIG -> consumerGroup,
      "zookeeper.connect" -> zookeeper
    )

    //4.通过KafkaUtil创建kafkaDSteam
    val kafkaDSteam: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream[String, String, StringDecoder, StringDecoder](
      ssc,
      kafkaParam,
      Map[String, Int](topic -> 1),
      StorageLevel.MEMORY_ONLY
    )





    //打印value
    kafkaDSteam.print

    //启动
    ssc.start()
    ssc.awaitTermination()
  }
}
