package com.dactent.sparksql.day1

import java.util.Properties

import org.apache.spark.sql.SparkSession

/**
  * @ClassName SparkSqltoMySql
  * @Description: 读取json文件到mysql
  * @Date 2019/11/21 
  **/
object SparkSqltoMySql {

  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder()
      .appName("SparkSqltoMySql")
      .master("local[*]").getOrCreate()
    //读取json 文件
    val df = spark.read
      .json("E:\\project\\bigdata\\data\\people.json")
      .toDF()
    //df.show()
    //查询年龄大于30 岁的行
    val resDF = df.where("age>30")

    //将结果输出到mysql
    val url="jdbc:mysql://192.168.245.210:3306/company"
    val table="person"
     val prop = new Properties()
    prop.setProperty("driver","com.mysql.jdbc.Driver")
    prop.setProperty("user","root")
    prop.setProperty("password","000000")
    //表会自动创建
    resDF.write.jdbc(url,table,prop)
  }

  case class Person(id:Int,name:String,age:Long)

}
