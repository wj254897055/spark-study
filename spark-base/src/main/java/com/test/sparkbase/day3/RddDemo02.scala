package com.test.sparkbase.day3

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RddDemo02 {

  class SearchFunction(val query: String){
    def isMacher(s:String)={
      s.contains(query)
    }

    def getMatchesFunction(rdd:RDD[String]) ={
      rdd.map(isMacher)
    }

    def getMatchesFieldReference(rdd: RDD[String])={
      rdd.map(x=>x.split(query))
    }

    def getMatchesRefence(rdd:RDD[String]) ={
      val query_ = this.query
      rdd.map(x=>x.split(query_))
    }
  }
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("rddDemo02")
    val sc = new SparkContext(conf)
    val valueRdd = sc.textFile("D:\\ideaProject\\spark-study\\spark-base\\src\\main\\resources\\log_info.log")
    val errorRdd = valueRdd.filter(line => line.contains("ERROR"))
    val warnRdd = valueRdd.filter(line => line.contains("WARN"))

    val badRdd = errorRdd.union(warnRdd)
    println("input had "+badRdd.count()+"  concerning lines")
    for (elem <- badRdd.take(10)) {
      println(elem)
    }

  }

}

