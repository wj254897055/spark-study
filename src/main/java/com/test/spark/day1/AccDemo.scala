package com.test.spark.day1

import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.{Map=>MMP}

/**
  * @ClassName AccDemo
  * @Description: 自定义累加器
  * @Date 2019/11/14 
  **/
object AccDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("AccDemo")
    val sc = new SparkContext(conf)


  }


  class MyAcc extends AccumulatorV2[(Int,Int),MMP[Int,(Int,Int)]](){

    var _value:MMP[Int,(Int,Int)] = MMP[Int,(Int,Int)]()

    override def isZero: Boolean = _value.isEmpty

    override def copy(): AccumulatorV2[(Int, Int), MMP[Int, (Int, Int)]] = ???

    //重置
    override def reset(): Unit = _value.clear()

    override def add(v: (Int, Int)): Unit = {
      val year=v._1
      val tmpe=v._2
      val oldvlue = _value.getOrElse(year,(tmpe,tmpe))

    }
    override def merge(other: AccumulatorV2[(Int, Int), MMP[Int, (Int, Int)]]): Unit = ???

    override def value: MMP[Int, (Int, Int)] = _value

  }

}
