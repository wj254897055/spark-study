package com.test.sparkbase.day3

import org.apache.spark.{SparkConf, SparkContext}

/**
 * 基本算子操作
 */
object RddDemo03 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("RddDemo03")
    val sc = new SparkContext(conf)
    val line = sc.parallelize(List(1,2,3,4,5))
    val value = line.map(x => x * 2)
    val str = value.collect().mkString(",")
    println(str)


  }
}
