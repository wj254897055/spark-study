package com.test.spark.day1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @ClassName SparkDemo
  * @Description: TODO 
  * @Date 2019/10/15 
  **/
object RDDSample {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Rdd sample").setMaster("local")
    val sc = new SparkContext(conf)

//    val rdd1 = sc.makeRDD(Seq("hello1","hello2","hello1","hello3","hello1","hello2"))
//    val rdd2 = rdd1.sample(withReplacement = true,1,100)
//    rdd2.collect().foreach(println)


//    val rdd1=sc.makeRDD(1 to 5)
//    val rdd2=sc.makeRDD(2 to 6)
//    val rdd3 = rdd1.union(rdd2) //union 不去重
//    val rdd4 = rdd1.intersection(rdd2)//交集
//    val rdd5 = rdd3.distinct()//去重


    val rdd1 = sc.makeRDD(Seq((1,"tom"),(20,"lilei"),(3,"xiaohong")))
    val rdd2 = sc.makeRDD(Seq((1,100),(2,89),(3,60)))

    val rdd3 = rdd1.join(rdd2) //内连接

    val rdd4 = rdd1.fullOuterJoin(rdd2)
    val rdd5 = rdd1.cogroup(rdd2)

    rdd1.repartition(1)

    rdd5.collect().foreach(println)

  }
}
