package com.datcent.sparkstream

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * @ClassName SparkStreamingTest
  * @Description: 统计每两秒钟之内的单词个数
  * @Date 2019/11/21 
  **/
object SparkStreamingTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("SparkStreamingTest")
    val ssc = new StreamingContext(conf,Seconds(2))
    //创建套接字流
    val lines = ssc.socketTextStream("192.168.245.210",9999)
    val res = lines
      .flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_+_)

    res.print()

    //启动上下文
    ssc.start()
    ssc.awaitTermination()



  }

}
