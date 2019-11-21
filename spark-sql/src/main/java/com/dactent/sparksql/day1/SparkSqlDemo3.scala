package com.dactent.sparksql.day1

import org.apache.spark.sql.SparkSession

/**
  * @ClassName SparkSqlDemo1
  * @Description: Spark SQL的Scala接口支持自动将包含案例类的RDD转换为DataFrame。
  * @Date 2019/11/20
  **/
object SparkSqlDemo3 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("spark sql demmo")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    val peopleDF=spark.sparkContext
      .textFile("E:\\project\\bigdata\\data\\ml-latest\\cust.txt")
      .map(line=>{
        val arr=line.split(",")
        (arr(0).toInt,arr(1),arr(2).toInt)
      })
      .toDF()
    peopleDF.show()

  }

}
