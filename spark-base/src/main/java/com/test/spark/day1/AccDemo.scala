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

    val mac=new MyAcc()
    sc.register(mac,"myacc")


    val rdd1=sc.textFile("file:///d:").map(line=>{
      val arr = line.split(" ")
      (arr(0).toInt,arr(1).toInt)
    })


  }


  class MyAcc extends AccumulatorV2[(Int,Int),MMP[Int,(Int,Int)]](){

    var _value:MMP[Int,(Int,Int)] = MMP[Int,(Int,Int)]()

    override def isZero: Boolean = _value.isEmpty

    override def copy(): AccumulatorV2[(Int, Int), MMP[Int, (Int, Int)]] = {

      val acc = new MyAcc
      acc._value=_value
      acc
    }

    //重置
    override def reset(): Unit = _value.clear()

    override def add(v: (Int, Int)): Unit = {
      val year=v._1
      val tmpe=v._2
      val oldvlue = _value.getOrElse(year,(tmpe,tmpe))
      _value.put(year,(Math.max(tmpe,oldvlue._1),Math.min(tmpe,oldvlue._2)))

    }
    override def merge(other: AccumulatorV2[(Int, Int), MMP[Int, (Int, Int)]]): Unit = {
      for ((k,t)<-other.value){
        val year =k
        val tmax =t._1
        val tmin =t._2
        val myvalue = _value.getOrElse(year,(tmax,tmin))
        _value.put(year,(Math.max(tmax,myvalue._1),Math.min(tmin,myvalue._2)))
      }
    }

    override def value: MMP[Int, (Int, Int)] = _value

  }

}
