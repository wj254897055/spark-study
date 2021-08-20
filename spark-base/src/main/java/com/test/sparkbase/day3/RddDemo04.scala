package com.test.sparkbase.day3

import org.apache.spark.{SparkConf, SparkContext}


/**
 * map和flatmap
 */
object RddDemo04 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("RddDemo04")
    val sc = new SparkContext(conf)

    val value = sc.parallelize(Array("a_1", "b_2", "c_1"))

    value.foreach(println(_))

   value.map(str => {
      str.split("_")
    }).foreach(ary => {
     println(ary.mkString(","))
    })

    value.flatMap(str=>{
      str.split("_")
    }).foreach(str=>{
      println(str)
    })


  }

}
