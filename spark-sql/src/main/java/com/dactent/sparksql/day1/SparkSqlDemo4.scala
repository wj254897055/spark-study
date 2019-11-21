package com.dactent.sparksql.day1

import org.apache.spark.sql.SparkSession

/**
  * @ClassName SparkSqlDemo1
  * @Description: spark 读取json 文件以对象的方式
  * @Date 2019/11/20
  **/
object SparkSqlDemo4 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("spark sql demmo")
      .master("local[*]")
      .getOrCreate()


  //val df2=spark.read.format("json").load("E:\\project\\bigdata\\data\\people.json")
    import spark.implicits._

    val df = spark.read.json("E:\\project\\bigdata\\data\\people.json").as[People]

    df.show()

  }


  case class People(name:String,age:Long)

}
