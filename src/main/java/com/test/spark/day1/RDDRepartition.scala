package com.test.spark.day1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @ClassName SparkDemo
  * @Description: TODO 
  * @Date 2019/10/15 
  **/
object RDDRepartition {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDRepartition").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val rdd1 = sc.makeRDD((1 to 10),5)
    println("rdd1 pars:"+rdd1.partitions.length)


    val rdd2=rdd1.map(e=>{
      val tname = Thread.currentThread().getName
      val tid = Thread.currentThread().getId
      println("分区前：%d/%s :%d\r\n",tid,tname,e)
      e
    })


    val rdd3 = rdd2.repartition(2)

    val rdd4=rdd2.map(e=>{
      val tname = Thread.currentThread().getName
      val tid = Thread.currentThread().getId
      println("分区前：%d/%s :%d\r\n",tid,tname,e)
      e
    })


    rdd4.collect()
  }
}
