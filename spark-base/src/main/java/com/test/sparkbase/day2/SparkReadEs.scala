package com.test.sparkbase.day2

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.elasticsearch.spark.rdd.EsSpark

/**
  * @ClassName SparkReadEs
  * @Description: TODO 
  * @Date 2019/10/30 
  **/
object SparkReadEs {



  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkReadEs").setMaster("local[*]")
      .set("cluster.name","elasticsearch")
      .set("es.nodes","es5x-node01.stage.dev.pi")
      .set("es.port","9200")
      .set("es.nodes.wan.only","true")
    val sc = new SparkContext(conf)
    readEs(sc)

    val jdbc_conf: Map[String, String] = Map(
      "url" -> "jdbc:mysql://10.128.2.2:3306/itoa",   //设置mysql的链接地址和指定数据库
      "driver" -> "com.mysql.jdbc.Driver",    //设置MySQL的链接驱动
      "user" -> "itoa",        //连接mysql的用户
      "password" -> "itoa"   //连接用户的密码
    )
    val spark=new SparkSession.Builder().getOrCreate()
    val reader = spark.read.format("jdbc").options(jdbc_conf).load()
    reader.show()

}


def readEs(sc: SparkContext) = {
  val value = EsSpark.esRDD(sc,"esb_default_jcnode-20191101")
  //value.collect().foreach(println)


}

}
