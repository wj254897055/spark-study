package com.test.sparkbase.day1

/**
  * 数据倾斜自定义分区
 */
import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

import scala.util.Random

/**
  * @ClassName 自定义分区 rdd中如果自定义了分区对象，shuffle 产生rdd时，应用的原来的分区对象
  *           需要使用原来特定的分区对象
  * @Description: TODO 
  * @Date 2019/10/15 
  **/
object RddDateskew {

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

    //随机分区
    class RandomPartition(val n:Int) extends Partitioner{

      override def numPartitions: Int = n

      override def getPartition(key: Any): Int = {
        Random.nextInt(n)
      }
    }
    //按随机分区结合
    val rdd4 = rdd3.reduceByKey(new RandomPartition(4),_+_)

    val rdd5 = rdd4.reduceByKey(new HashPartitioner(3),_+_)

    rdd5.collect().foreach(println)

  }
}
