package com.wcq.mysql

import java.sql.{DriverManager, ResultSet}

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}

object TestMysqlRDD {

  def main(args: Array[String]): Unit = {

    //1.创建sparkconf
    val sparkConf = new SparkConf().setAppName("testmysql").setMaster("local[*]")

    //2.创建sparkcontext
    val sc = new SparkContext(sparkConf)

    //3.mysql参数
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://hadoop102:3306/rdd"
    val userName = "root"
    val passWd = "000000"

    //创建mysql的RDD
    val jdbcRDD = new JdbcRDD[Int](sc,
      () => {
        Class.forName(driver)

        DriverManager.getConnection(url, userName, passWd)
      },
      "select * from order_info where ? <= id and id <=?;",
      1,
      5,
      1,
      (x: ResultSet) => (x.getInt(1)))

      jdbcRDD.foreach(println)

    sc.stop()
  }
}
