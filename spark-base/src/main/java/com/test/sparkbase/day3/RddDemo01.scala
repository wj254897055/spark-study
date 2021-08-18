package com.test.sparkbase.day3

import org.apache.spark.{SparkConf, SparkContext}

/** *
 * 创建rdd
 */
object RddDemo01 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("rddDemo01")
    val sc = new SparkContext(conf)
    val valueRdd = sc.textFile("D:\\ideaProject\\spark-study\\spark-base\\src\\main\\resources\\sharing.log")
    valueRdd.foreach(println(_))
    val value = valueRdd.filter(line => line.contains("0000103")).foreach(println(_))
  }
}
