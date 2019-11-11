package com.test.spark.day1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @ClassName SparkDemo
  * @Description: TODO 
  * @Date 2019/10/15 
  **/
object SparkAggDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Rdd sample").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.makeRDD(1 to 10,3)
    val rdd2 = rdd1.map(("hello",_))
    //zero
    val u:String="S"
    //sequop
    def seqOp(u:String,v:Int): String ={
      u+","+v
    }
    def combop(u1:String,u2:String): String ={
      u1+"||"+u2
    }
    val rdd3 = rdd2.aggregateByKey(u)(seqOp,combop)
    rdd3.collect().foreach(println)

  }
}
