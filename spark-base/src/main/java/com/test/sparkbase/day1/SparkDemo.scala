package com.test.sparkbase.day1

/**
  * 获取历年气温
 */
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @ClassName SparkDemo
  * @Description: TODO 
  * @Date 2019/10/15 
  **/
object SparkDemo {

  val filepath: String = "file:///D:\\wujing\\data\\temp.txt"

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("SparkDemo")
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile(filepath)
    val rdd2=rdd1.map(line=>{
      val str = line.split(" ")
      val year = str(0).toInt
      val wd = str(1).toInt
      (year,(wd,wd,wd,1,wd.toDouble))
    })
    rdd2.reduceByKey((t1,t2)=>{
      val max = Math.max(t1._1,t2._1)
      val min = Math.min(t1._2,t2._2)
      val sum = t1._3+t2._3
      val cou=t1._4+t2._4
      val avg=sum/cou
      (max,min,sum,cou,avg)
    }).sortByKey().collect().foreach(println)
  }

}
