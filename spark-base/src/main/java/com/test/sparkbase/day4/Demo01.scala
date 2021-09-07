package com.test.sparkbase.day4

import org.apache.spark.{SparkConf, SparkContext}

object Demo01 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Demo01")
    val sc = new SparkContext(conf)

    val input = sc.parallelize(List(1, 2, 3,1))
    println(input.collect().mkString("Array(", ", ", ")"))
    println(input.count())
    println(input.countByValue())
    println(input.take(1).mkString("Array(", ", ", ")"))
    println(input.top(2).mkString("Array(", ", ", ")"))
    println(input.reduce((x,y)=>x+y))
    val tuple = input.aggregate((1, 0, 0))((acc, number) => (acc._1 * number, acc._2 + number, acc._3 + 1),
      (x, y) => (x._1 * y._1, x._2 + y._2, x._3 + y._3))
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
  }

}
