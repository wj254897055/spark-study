package com.dactent.sparksql.day1

import java.util.Properties

import org.apache.spark.sql.SparkSession

/**
  * @ClassName SparkSqltoMySql
  * @Description: 读取json文件到mysql
  * @Date 2019/11/21 
  **/
object SparkSqlReadMySql {

  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder()
      .appName("SparkSqltoMySql")
      .master("local[*]").getOrCreate()

    //创建myqsl lianjie
    val url="jdbc:mysql://192.168.245.210:3306/company"
    val table="sc"
    val prop = new Properties()
    prop.setProperty("driver","com.mysql.jdbc.Driver")
    prop.setProperty("user","root")
    prop.setProperty("password","000000")
    //读取json 文件
    val df = spark.read.jdbc(url,table,prop)
    df.show(100)
  }

}
