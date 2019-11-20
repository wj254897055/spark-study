package com.test.spark.day1

/**
  * 获取历年气温
 */
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer

/**
  * @ClassName WordCountWhitIndex
  * @Description: TODO 
  * @Date 2019/10/15 
  **/
object WordCountDemo {

  val filepath: String = "file:///D:/wujing/data/hello.txt"

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("RDDDemo")
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile(filepath,3)
    //压扁
    val rdd2=rdd1.flatMap(line=>{
      line.split(" ")
    })
    val rdd3 = rdd2.map((_,1))
    val rdd4=rdd3.mapPartitionsWithIndex((ind,its)=>{
      val buf = ArrayBuffer[(String,(Int,Int))]()
      for (x<-its){
        buf.append((x._1,(ind,x._2)))
      }
      buf.iterator
    })
    val zeroU=""

    //分区内聚合
    def seqOp(a: String,b:(Int,Int)):String={
      if (a.equals("")){
        b._1+":"+b._2
      }else{
        val arr = a.split(":")
        val inte = arr(1).toInt
        arr(0)+":"+(inte+b._2)
      }
    }

    def comOp(a:String,b:String):String={
      a+"-"+b
    }
    val rdd5 = rdd4.aggregateByKey(zeroU)(seqOp,comOp)

    rdd5.collect().foreach(println)

  }
}
