package com.test.sparkbase.day3

import org.apache.spark.{SparkConf, SparkContext}


object RddDemo05 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("RddDemo05")
    val sc = new SparkContext(config = conf)
    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5))
    val rdd2 = sc.parallelize(List(2, 5, 2, 1, 1))

    //笛卡尔积的
//    rdd1.cartesian(rdd2).foreach(x=>{
//      println(x._1,x._2)
//    })

    //对rdd1 转换操作
    //map()
    rdd1.map(x=>(x+1)).foreach(println(_))
    //对rdd1 flatmap
    rdd1.flatMap(x=>x.to(4)).foreach(println(_))
    //

  }
}
