package com.test.spark.day1

/**
  * 获取历年气温
 */
import java.sql.DriverManager

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @ClassName SparkDemo
  * @Description: TODO 
  * @Date 2019/10/15 
  **/
object RDDDemo {

  val filepath: String = "file:///D:\\wujing\\data\\hello.txt"

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("RDDDemo")
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile(filepath,3)
    val rdd2 = rdd1.map((_,1))
    val rdd3 = rdd2.reduceByKey(_+_)
    rdd3.foreachPartition(it=>{
      Class.forName("com.mysql.jdbc.Driver")
      val conn = DriverManager.getConnection("jdbc:mysql://192.168.245.210:3306/company","root","000000")
      conn.setAutoCommit(false)
      val sql="INSERT INTO `company`.`sc`(`word`, `cont`) VALUES (?, ?)"
      val paps = conn.prepareStatement(sql)
      for (t<-it){
        val word = t._1
        val cont = t._2
        paps.setString(1,word)
        paps.setInt(2,cont)
        paps.executeUpdate()
      }
      conn.commit()
      paps.close()
      conn.close()
      System.out.println("-----over----")
    })

  }
}
